import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Class to represent a graph
 * 
 * @author SujitS
 */

class Graph implements Iterable<Vertex> {
    public List<Vertex> verts;      // array of vertices
    public int numNodes;            // number of verices in the graph
    public int numEdges;            // number of edges in the graph

    /**
     * Constructor for Graph
     *
     * @param size : int - number of vertices
     */
    Graph(int size, int edges) {
        numNodes = size;
        numEdges = edges;
        verts = new ArrayList<>(size + 1);
        verts.add(0, null);
        // create an array of Vertex objects
        for (int i = 1; i <= size; i++)
            verts.add(i, new Vertex(i));
    }

    /**
     * Method to add an edge to the graph
     *
     * @param a      : int - one end of edge
     * @param b      : int - other end of edge
     * @param weight : int - the weight of the edge
     */
    void addDirectedEdge(int a, int b, int weight) {
        Vertex u = verts.get(a);
        Vertex v = verts.get(b);
        Edge e = new Edge(u, v, weight);
        u.Adj.add(e);
        v.revAdj.add(e);
    }

    /**
     * Helper function to initialize the graph
     */
    void initialize(){
        for(Vertex v:verts.subList(1, numNodes+1)){
            v.distance = 0;
            v.seen = false;
        }
    }

    /**
     * Method to create an instance of VertexIterator
     */
    @Override
    public Iterator<Vertex> iterator() {
        return new VertexIterator();
    }

    /**
     * A Custom Iterator Class for iterating through the vertices in a graph
     */
    private class VertexIterator implements Iterator<Vertex> {
        private Iterator<Vertex> it;

        /**
         * Constructor for VertexIterator
         */
        private VertexIterator() {
            it = verts.iterator();
            it.next();  // Index 0 is not used.  Skip it.
        }

        /**
         * Method to check if there is any vertex left in the iteration
         * Overrides the default hasNext() method of Iterator Class
         * 
         * @return  True - If it has another element
         *          False - If it does not have another element
         */
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        /**
         * Method to return the next Vertex object in the iteration
         * Overrides the default next() method of Iterator Class
         * 
         * @return next vertex
         */
        @Override
        public Vertex next() {
            return it.next();
        }

        /**
         * Throws an error if a vertex is attempted to be removed
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static Graph readGraph(Scanner in) {
        // read the graph related parameters
        int n = in.nextInt(); // number of vertices in the graph
        int m = in.nextInt(); // number of edges in the graph
        // create a graph instance
        Graph g = new Graph(n, m);
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g.addDirectedEdge(u, v, w);
        }
        in.close();
        return g;
    }

}