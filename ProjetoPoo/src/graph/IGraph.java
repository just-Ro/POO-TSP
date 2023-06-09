package graph;

public interface IGraph<T, E> {

    // This function adds a new node to the graph
    void addNode(T node);

    // This function adds the edge between source to destination
    void addEdge(T source, T destination, E edge);

    // This function gives the count of nodes
    int getNodeCount();

    // This function gives the total count of edges
    int getEdgeCount();

    // This function gives the count of edges connected to a specific node
    int getEdgeCount(T v);

    // This function gives whether a node is present or not.
    boolean hasNode(T node);

    // This function gives whether an edge is present or not.
    boolean hasEdge(T source, T destination);

}