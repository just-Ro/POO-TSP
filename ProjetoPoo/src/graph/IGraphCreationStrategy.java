package graph;

public interface IGraphCreationStrategy {
    public void fill(WeightedGraph graph, int nodes, int maxWeight, String file);
}
