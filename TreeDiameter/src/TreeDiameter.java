import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * To find the diameter of the given tree
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-05-01
 */

public class TreeDiameter {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sampleInput.txt"));
        Graph g = Graph.readGraph(sc);
        int diameter = findDiameter(g);
        if(diameter < 0)
            System.out.println("The given graph is a forest");
        else
            System.out.println("The diameter of given tree is "+diameter);
    }

    /**
     * Function to find the diameter of the given graph
     * 
     * @param g Undirected graph
     * 
     * @return Diameter of the given graph
     */
    private static int findDiameter(Graph g) {
        Vertex src = g.verts.get(1);
        BFS(g,src);
        src = findMaxDistantVertex(g);
        if(src==null)
            return -1;
        g.initialize();
        BFS(g,src);
        src = findMaxDistantVertex(g);
        return src.distance;
    }

    /**
     * Function to implement Breadth first search for the given graph
     * 
     * @param g Undirected graph
     * @param src Vertex to start BFS with
     */
    private static void BFS(Graph g, Vertex src) {
        ArrayDeque<Vertex> q = new ArrayDeque<>();
        q.add(src);
        src.seen = true;
        src.distance = 0;
        while(!q.isEmpty()){
            Vertex v = q.poll();
            for(Edge e:v.Adj){
                Vertex u = e.otherEnd(v);
                if(!u.seen){
                    u.seen = true;
                    q.add(u);
                    u.distance = v.distance + 1;
                }
            }
        }
    }

    /**
     * Function to find the vertex which is at maximum distance from root
     * 
     * @param g Undirected graph
     * 
     * @return Vertex at maximum distance from root
     */
    private static Vertex findMaxDistantVertex(Graph g) {
        int maxDistance = -1;
        Vertex maxDisVertex = null;
        for(Vertex v : g){
            if(!v.seen)
                return null;
            if(v.distance>maxDistance){
                maxDistance = v.distance;
                maxDisVertex = v;
            }
        }
        return maxDisVertex;
    }
    
}