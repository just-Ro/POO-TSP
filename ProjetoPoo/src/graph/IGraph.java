package graph;

public interface IGraph {

    int getWeight(int n1, int n2);
    void initGraph();
    void readGraph(String file);
    void createGraph(int n, int maxEdgeWeight);
    void getAdjacent(int node);
    String toString();
    double getPheromones(int n1, int n2);

}