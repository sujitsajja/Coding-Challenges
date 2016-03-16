import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a graph
 * 
 * @author SujitS
 */

class Graph{
    public List<Vertex> verts;  // array of vertices
    public int numNodes;        // number of verices in the graph

    /**
     * Constructor for graph class
     * 
     * @param size Number of vertices in the graph
     */
    Graph(int size) {
	numNodes = size;
	verts = new ArrayList<>(size + 1);
	verts.add(new Vertex(0));
	// create an array of Vertex objects
	for (int i = 1; i <= size; i++)
	    verts.add(i, new Vertex(i));
    }

    /**
     * Function to add a directed edge between two given vertices
     * 
     * @param a Vertex from
     * @param b Vertex to
     * @param weight Weight of the the edge
     */
    void addDirectedEdge(int a, int b, int weight) {
	Vertex head = verts.get(a);
	Vertex tail = verts.get(b);
	Edge e = new Edge(head, tail, weight);
	head.Adj.add(e);
    }

    /**
     * Function to construct a graph given matrix as input
     * 
     * @param input Matrix
     */
    public void constructGraph(int[][] input){
        int m = input.length;       // Number of rows
        int n = input[0].length;    // Number of cols
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // Store the matrix element in value field of its respective vertex
                Vertex current = verts.get(i*m+j+1);
                current.value = input[i][j];
                // Add directed edge between neighbors only if
                // the neighbor value is more than the current value
                if(j!=0){
                    if(input[i][j]<input[i][j-1])
                        addDirectedEdge(i*m+j+1, i*m+j, -1);
                }
                if(j!=n-1){
                    if(input[i][j]<input[i][j+1])
                        addDirectedEdge(i*m+j+1, i*m+j+2, -1);
                }
                if(i!=0){
                    if(input[i][j]<input[i-1][j])
                        addDirectedEdge(i*m+j+1, (i-1)*m+j+1, -1);
                }
                if(i!=m-1){
                    if(input[i][j]<input[i+1][j])
                        addDirectedEdge(i*m+j+1, (i+1)*m+j+1, -1);
                }
                // Consider a zero node as source which has an edge to all the vertices
                addDirectedEdge(0,i*m+j+1, -1);
            }
        }
    }

    /**
     * Function to find the shortest path using DAG shortest path algorithm
     */
    public void directedAcyclicGraph(){
        // Find the topological sorting of the graph with zero node as source
        ArrayDeque<Vertex> stack = new ArrayDeque<>();
        DFS(verts.get(0),stack);
        // Set the distances of all vertices to infinity other than zero node
        for(Vertex v:verts)
            v.distance = Integer.MAX_VALUE;
        verts.get(0).distance = 0;
        while(!stack.isEmpty()){
            Vertex current = stack.pop();
            for(Edge e:current.Adj){
                Vertex otherVertex = e.otherEnd(current);
                if(otherVertex.distance > current.distance + e.Weight){
                    otherVertex.distance = current.distance + e.Weight;
                    otherVertex.parent = current;
                }
            }
        }
    }

    /**
     * Function to perform DFS for finding Topological sorting
     * 
     * @param src Source vertex
     * @param stack A stack to store vertices in the order
     *              of their topological sort
     */
    private void DFS(Vertex src, ArrayDeque<Vertex> stack) {
        src.seen = true;
        for(Edge e:src.Adj){
            Vertex otherEnd = e.otherEnd(src);
            if(!otherEnd.seen)
                DFS(otherEnd,stack);
        }
        stack.push(src);
    }

}