import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Find the number of strongly connected components in the given graph
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-05-01
 */

public class StronglyConnectedComponents {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sampleInput.txt"));
        Graph g = Graph.readGraph(sc);
        int result = findSCC(g);
        System.out.println("The number of strongly connected components"
                + " in the given graph are "+result);
    }

    /**
     * Function to find the number of strongly connected components
     * 
     * @param g Directed graph
     * 
     * @return Number of strongly connected components
     */
    private static int findSCC(Graph g) {
        ArrayDeque<Vertex> stack = new ArrayDeque<>();
        DFS(g,stack);
        g.initialize();
        return DFSReverse(g,stack);
    }

    /**
     * Function to implement Depth first search of the given graph
     * 
     * @param g Directed graph
     * @param stack Stores current topological order
     */
    private static void DFS(Graph g, ArrayDeque<Vertex> stack) {
        for(Vertex v:g){
            if(!v.seen){
                v.seen = true;
                DFSVisit(g,v,stack);
            }
        }
    }

    /**
     * Recursive helper function for DFS
     * 
     * @param g Directed graph
     * @param v Current vertex
     * @param stack Stores current topological order
     */
    private static void DFSVisit(Graph g, Vertex v, ArrayDeque<Vertex> stack) {
        for(Edge e:v.Adj){
            Vertex u = e.otherEnd(v);
            if(!u.seen){
                u.seen = true;
                DFSVisit(g, u, stack);
            }
        }
        stack.push(v);
    }

    /**
     * Function to find depth first search on reverse graph
     * 
     * @param g Directed graph
     * @param stack Stores topological order
     * 
     * @return number of strongly connected components
     */
    private static int DFSReverse(Graph g, ArrayDeque<Vertex> stack) {
        int scc = 0;
        while(!stack.isEmpty()){
            Vertex v = stack.pop();
            if(!v.seen){
                scc++;
                v.seen = true;
                DFSReverseVisit(g,v,scc);
            }
        }
        return scc;
    }

    /**
     * Recursive helper function for DFS on reverse graph
     * 
     * @param g Directed graph
     * @param v Current vertex
     * @param scc Current component number
     */
    private static void DFSReverseVisit(Graph g, Vertex v, int scc) {
        for(Edge e:v.revAdj){
            Vertex u = e.otherEnd(v);
            if(!u.seen){
                u.seen = true;
                u.componentNumber = scc;
                DFSReverseVisit(g, u, scc);
            }
        }
    }

}