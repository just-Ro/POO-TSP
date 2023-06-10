package graph;

import java.util.*;

public class WeightGraph extends AGraph<Integer,Integer>{
    private Map<String,IGraphCreationStrategy> graphCreators;
    private IGraphCreationStrategy graphCreatorStrat;

	public WeightGraph(){
		super(true);
	}

	public void createGraph(Integer nodes, Integer maxWeight, String file){
		if (graphCreatorStrat == null) {
            throw new IllegalStateException("Strategy is not set. Please set the strategy before executing.");
        }
		graphCreatorStrat.fill(this, nodes, maxWeight, file);
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

	public void insertGraphCreationStrat(String mode, IGraphCreationStrategy strat){
        this.graphCreators.put(mode, strat);
    }

    public void setGraphCreationStrat(String mode){
        this.graphCreatorStrat = this.graphCreators.get(mode);
    }
}
