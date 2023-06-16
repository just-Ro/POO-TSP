package graph;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public interface IGraphCreationStrategy {
    public void fill(WeightedGraph graph, int nodes, int maxWeight, String file);
}
