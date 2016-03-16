import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given a matrix of numbers, find a chain of monotonically increasing numbers.
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-15
 */

public class MatrixChainMonotonicallyIncreasing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int m = sc.nextInt();
        System.out.print("Enter the number of cols : ");
        int n = sc.nextInt();
        int[][] input = new int[m][n];
        System.out.println("Enter the elements seperated by Space/Enter : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                input[i][j] = sc.nextInt();
        }
        ArrayList<Integer> chain = findChain(input);
        System.out.println("The longest chain of monotonically "
                + "increasing elements in the given array is :");
        for(int x:chain)
            System.out.print(x+" ");
        System.out.println();
    }

    /**
     * Function to find the longest chain of monotonically
     * Increasing elements in the given array
     * 
     * @param input matrix
     * 
     * @return list of elements that form longest monotonically increasing chain
     */
    private static ArrayList<Integer> findChain(int[][] input) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = input.length;
        int n = input[0].length;
        Graph g = new Graph(m*n);
        // Construct a graph based on given input matrix
        g.constructGraph(input);
        // Find the shortest paths to all the vertices
        // from src using DAG shortest path algorithm
        g.directedAcyclicGraph();
        // Find the vertex which is farthest from the source
        Vertex lastElement = null;
        int minimum = 0;
        for(Vertex v:g.verts){
            if(v.distance<minimum){
                minimum = v.distance;
                lastElement = v;
            }
        }
        // Find the elements using backtracking
        while(lastElement!=g.verts.get(0)){
            result.add(lastElement.value);
            lastElement = lastElement.parent;
        }
        // They will be stored in reverse order because of backtracking
        Collections.reverse(result);
        // Instead of reversing we could have directly stored in a stack
        return result;
    }

}

/**
 * Sample input:
 * 4
 * 4
 * 5  10 7  9
 * 4  6  8  20
 * 30 35 1  2
 * 19 14 11 3
 * 
 * Sample output:
 * 1 2 3 11 14 19 30 35
 */