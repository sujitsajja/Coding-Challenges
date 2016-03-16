/**
 * A class to represent an edge of the graph
 * 
 * @author SujitS
 */

public class Edge {
    public Vertex From; // head vertex
    public Vertex To; // tail vertex
    public int Weight;// weight of the arc

    /**
     * Constructor for edge class
     * 
     * @param u From Vertex
     * @param v To Vertex
     * @param w Weight of the edge
     */
    Edge(Vertex u, Vertex v, int w) {
	From = u;
	To = v;
	Weight = w;
    }

    /**
     * Function to find the other end of edge given a vertex
     * 
     * @param u Vertex
     * 
     * @return Other end of edge
     */
    public Vertex otherEnd(Vertex u) {
	if (From == u)
	    return To;
	else
	    return From;
    }

}