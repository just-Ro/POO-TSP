package ant_colony_optimization;

import java.util.Set;

import graph.AGraph;

/**
 * The PheroGraph class represents a graph used for pheromone levels in ant colony optimization.
 * It extends the AGraph<Integer, Double> class, which provides the basic graph structure and operations.
 * Pheromone levels are stored as edge weights in the graph.
 * The class allows for updating the pheromone levels of edges and retrieving information about the graph.
 * 
 * Pheromone levels are updated using the {@link #updateEdge(int, int, double)} method, which adds a value to an edge.
 * The class also overrides the {@link #toString()} method to provide a string representation of the adjacency matrix
 * of the graph, displaying the pheromone levels of each edge.
 * 
 * This class assumes that the pheromone levels are represented as {@code double} values.
 * Negative pheromone levels are not allowed, and any resulting negative value is set to zero.
 * 
 * @see AGraph
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class PheroGraph extends AGraph<Integer, Double> {

	/**
     * Constructs a PheroGraph with the specified bidirectional flag.
     * If the bidirectional flag is set to {@code true}, the graph will allow bidirectional edges.
     * If the bidirectional flag is set to {@code false}, the graph will only allow unidirectional edges.
     * 
     * @param bidirectional the flag indicating whether the graph allows bidirectional edges
     */
    public PheroGraph(boolean bidirectional) {
        super(bidirectional);
    }

    // This function updates an edge by adding a value to it
    public void updateEdge(int source, int destination, double value){
        if(hasEdge(source, destination)){
			setEdge(source, destination, getEdge(source, destination) + value);
        } else {
			setEdge(source, destination, value);
		}
		// Pheromone level can't be negative
		if(getEdge(source,destination) < 0.0){
			setEdge(source, destination, 0.0);
		}
		
    }

    // This function prints the adjancency list of each node.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Set<Integer> nodes = getNodes();
		for( Integer source : nodes){
			for(Integer destination : nodes){
				builder.append(hasEdge(source, destination) ? String.format("%.2f", getEdge(source, destination)) : "    ");
				builder.append(" ");
			}
			builder.append("\n");
		}

		return builder.toString();
	}
}
