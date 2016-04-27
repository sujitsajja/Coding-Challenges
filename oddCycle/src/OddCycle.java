import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Given a graph find all the odd length cycles
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-26
 */

public class OddCycle {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sampleInput.txt"));
        Graph g = Graph.readGraph(sc);
        BFS(g);
        findCycle(g);
    }

    /**
     * Function to find the breadth first search of the given graph
     * 
     * @param g Given Undirected graph
     */
    private static void BFS(Graph g) {
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        Vertex root = g.verts.get(1);
        queue.add(root);
        root.distance = 0;
        root.seen = true;
        while(!queue.isEmpty()){
            Vertex u = queue.poll();
            for(Edge e:u.Adj){
                Vertex v = e.otherEnd(u);
                // If the vertex is not visited earlier
                // then we add it to the queue
                if(!v.seen){
                    v.seen = true;
                    v.distance = u.distance + 1;
                    v.parent = u;
                    queue.add(v);
                }
            }
        }
    }

    /**
     * Function to find odd length cycle from the given graph
     * 
     * @param g given undirected graph
     */
    private static void findCycle(Graph g) {
        boolean foundCycle = false;
        for(Vertex u:g){
            for (Edge e : u.Adj) {
                e.seen = false;
            }
        }
        for(Vertex u:g){
            for(Edge e:u.Adj){
                Vertex v = e.otherEnd(u);
                if(v.distance == u.distance && !e.seen){
                    printCycle(u,v);
                    foundCycle = true;
                }
                e.seen = true;
            }
        }
        if(!foundCycle)
            System.out.println("There are no odd length cycles in the given graph");
    }

    /**
     * Function to print the odd length cycle given
     * two vertices which are on the cycle
     * 
     * @param u Vertex 1 on cycle
     * @param v Vertex 2 on cycle
     */
    private static void printCycle(Vertex u, Vertex v) {
        ArrayDeque<Vertex> list1 = new ArrayDeque<>();
        ArrayDeque<Vertex> list2 = new ArrayDeque<>();
        list1.add(u);
        list2.push(v);
        u = u.parent;
        v = v.parent;
        while(u!=v){
            list1.add(u);
            list2.push(v);
            u = u.parent;
            v = v.parent;
        }
        for(Vertex temp:list1)
            System.out.print(temp+" ");
        System.out.print(u+" ");
        while(!list2.isEmpty())
            System.out.print(list2.pop()+" ");
        System.out.println();
    }

}