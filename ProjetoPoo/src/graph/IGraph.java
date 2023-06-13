package graph;

import java.util.Set;

public interface IGraph<N, E> {

    // This function adds a new node to the graph
    public void addNode(N node);

    // This function adds the edge from source to destination
    public void addEdge(N source, N destination, E edge);

    // This function gives the count of nodes
    public int getNodeCount();

    // This function gives the total count of edges
    public int getEdgeCount();

    // This function gives the count of edges connected to a specific node
    public int getEdgeCount(N v);

    // This function gives whether a node is present or not.
    public boolean hasNode(N node);

    // This function gives whether an edge is present or not.
    public boolean hasEdge(N source, N destination);

    // This function gives a set of all nodes
	public Set<N> getNodes();

    // This function gives the set of nodes adjacent to a particular node
	public Set<N> getNeighbours(N v);

    // This function gives the edge present from source to destination or null if no edge found
	public E getEdge(N source, N destination);

    // This function updates the edge from source to destination
    public void setEdge(N source, N destination, E edge);

}