package graph;

import java.util.Set;

public interface IGraph<T, E> {

    // This function adds a new node to the graph
    public void addNode(T node);

    // This function adds the edge from source to destination
    public void addEdge(T source, T destination, E edge);

    // This function gives the count of nodes
    public int getNodeCount();

    // This function gives the total count of edges
    public int getEdgeCount();

    // This function gives the count of edges connected to a specific node
    public int getEdgeCount(T v);

    // This function gives whether a node is present or not.
    public boolean hasNode(T node);

    // This function gives whether an edge is present or not.
    public boolean hasEdge(T source, T destination);

    // This function gives a set of all nodes
	public Set<T> getNodes();

    // This function gives the set of nodes adjacent to a particular node
	public Set<T> getNeighbours(T v);

    // This function gives the edge present from source to destination or null if no edge found
	public E getEdge(T source, T destination);

    // This function updates the edge from source to destination
    public void setEdge(T source, T destination, E edge);

}