package graph;

public interface IGraphCreationStrategy {
    public void fill(WeightGraph graph, int nodes, int maxWeight, String file);
}
