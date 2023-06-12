package graph;

import java.util.*;

/* Interface for Modifying Edges Graph whose edge values are constatly being modified
 * 
 * It contains all methods of a static graph as well 
 * 
 */
public abstract class IMEgraph<T,E> extends AGraph<T,E>{

	public IMEgraph(boolean bidirectional) {
		super(bidirectional);
		//TODO Auto-generated constructor stub
	}

	// Method to get the pheromone value on an edge between two vertices
    public abstract E getModValue(T source, T destination);

	// Method to set the pheromone value on an edge simply by substitution
	public abstract void setModValue(T source, T destination, E newValue);

	// Method to update the pheromone value on an edge between two vertices according to a rule
    public abstract void updateModValue(T source, T destination, E workValue);

    // Prints the adjancency list of each vertex.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Set<T> vertexes = getNodes();
		for( T source : vertexes){
			builder.append(source.toString()).append(": ");	// Name of the vertex
			Set<T> neighbours = getNeighbours(source);
			for(T destination : neighbours){
				builder.append("(");
				builder.append(destination.toString());
				builder.append(" ");
				builder.append(String.format("%.2f", getEdge(source, destination)));
				builder.append(") ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
