import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent vertex of a graph
 * 
 * @author SujitS
 */

public class Vertex {
    public int name; // name of the vertex
    public boolean seen; // flag to check if the vertex has already been visited
    public Vertex parent; // parent of the vertex
    public int distance; // distance to the vertex from the source vertex
    public List<Edge> Adj; // adjacency list
    public int value;

    /**
     * Constructor for vertex class
     * 
     * @param n Name of the vertex
     */
    Vertex(int n) {
	name = n;
	seen = false;
	parent = null;
	Adj = new ArrayList<>();
        value = 0;
    }

}