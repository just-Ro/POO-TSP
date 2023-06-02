package graph;

public interface IGraph {

    void initGraph();

    void readGraph(String file);

    void createGraph(int n, int maxEdgeWeight);

    String toString();

    void getAdjacent(int node);

    int getWeight(int n1, int n2);

    double getPheromones(int n1, int n2);

}