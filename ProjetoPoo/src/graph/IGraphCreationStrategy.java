package graph;

/**
 * The IGraphCreationStrategy interface represents a strategy for creating and filling a WeightedGraph with nodes and edges.
 * It provides a method to fill the graph based on specific parameters.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see GraphGeneratorStrategy
 * @see GraphReaderStrategy
 */
public interface IGraphCreationStrategy {
    public void fill(WeightedGraph graph, int nodes, int maxWeight, String file);
}
