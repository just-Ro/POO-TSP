package graph;

import java.util.Set;

/**
 * The IGraph interface represents a generic graph.
 * It defines operations to add nodes and edges, retrieve information about the graph,
 * and perform various graph-related operations.
 *
 * @param <N> the type of nodes in the graph
 * @param <E> the type of edges in the graph
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public interface IGraph<N, E> {

    /**This function adds a new node to the graph
     * @param node The node to add
     */
    public void addNode(N node);

    /**This function adds the edge from source to destination
     * @param source
     * @param destination
     * @param edge Value of the Edge to add
     */
    public void addEdge(N source, N destination, E edge);

    /**This function gives the count of nodes
     * @return count of nodes
     */
    public int getNodeCount();

    /**This function gives the total count of edges
     * @return count of edges
     */
    public int getEdgeCount();

    /**This function gives the count of edges connected to a specific node
     * @param v Specific Node
     * @return Number of edges
     */
    public int getEdgeCount(N v);

    /**This function gives whether a node is present or not.
     * @param node Node to check
     * @return True if node is present
     */
    public boolean hasNode(N node);

    /**This function gives whether an edge is present or not.
     * @param source
     * @param destination
     * @return True if it has the Edge
     */
    public boolean hasEdge(N source, N destination);

	/**This function gives a set of all nodes
	 * @return
	 */
	public Set<N> getNodes();

	/** This function gives the set of nodes adjacent to a particular node
	 * @param v Particular node
	 * @return the Set of nodes 
	 */
	public Set<N> getNeighbours(N v);

	/**This function gives a specific edge
	 * @param source
	 * @param destination
	 * @return The edge present from source to destination or null if no edge found
	 */
	public E getEdge(N source, N destination);


    /**This function updates the edge from source to destination
     * @param source
     * @param destination
     * @param edge New Value for the edge
     */
    public void setEdge(N source, N destination, E edge);

}