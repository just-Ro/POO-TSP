package graph;

public interface IGraphCreationStrategy {
    public void fill(WeightGraph graph, Integer nodes, Integer maxWeight, String file);
}
