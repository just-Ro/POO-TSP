package ant_colony_optimization;

import java.util.*;
import graph.*;

public class Pheromones extends AGraph<Integer,Double>{
    
    public Pheromones(){
		super(true);

	}


    // Prints the adjancency list of each vertex.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Set<Integer> vertexes = getNodes();
		for( Integer source : vertexes){
			builder.append(source.toString()).append(": ");	// Name of the vertex
			Set<Integer> neighbours = getNeighbours(source);
			for(Integer destination : neighbours){
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
