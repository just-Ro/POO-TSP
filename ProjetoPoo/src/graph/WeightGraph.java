package graph;

import java.util.*;

public class WeightGraph extends AGraph<Integer,Integer>{
    
	public WeightGraph(){
		super(true);
	}

    // Prints the adjancency list of each node.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Set<Integer> nodes = getNodes();
		for( Integer source : nodes){
			builder.append(source.toString()).append(": ");	// Name of the node
			Set<Integer> neighbours = getNeighbours(source);
			for(Integer destination : neighbours){
				builder.append("(");
				builder.append(destination.toString());
				builder.append(" ");
				builder.append(getEdge(source, destination).toString());
				builder.append(") ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
