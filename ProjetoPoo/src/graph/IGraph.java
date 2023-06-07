package graph;

public interface IGraph<T, E> {

    // This function adds a new vertex to the graph
    void addVertex(T vertex);

    // This function adds the edge between source to destination
    void addEdge(T source, T destination, E edge);

    // This function gives the count of vertices
    int getVertexCount();

    // This function gives the total count of edges
    int getEdgeCount();

    // This function gives the count of edges connected to a specific vertex
    int getEdgeCount(T v);

    // This function gives whether a vertex is present or not.
    boolean hasVertex(T vertex);

    // This function gives whether an edge is present or not.
    boolean hasEdge(T source, T destination);

}