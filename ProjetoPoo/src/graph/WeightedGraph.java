package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The WeightedGraph class represents a weighted graph.
 * It extends the AGraph class and provides additional functionality for managing weighted edges.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class WeightedGraph extends AGraph<Integer,Integer> {
    private Map<String,IGraphCreationStrategy> graphCreators;
    private IGraphCreationStrategy graphCreatorStrat;
	private int W;

	/**
     * Constructs a WeightedGraph object.
     * Initializes the graph with bidirectional edges.
     */
	public WeightedGraph(){
		super(true);
		this.graphCreators = new HashMap<>();
	}
	
	// This function initializes the graph with the given strategy
	public void createGraph(int nodes, int maxWeight, String file){
		if (graphCreatorStrat == null) {
			throw new IllegalStateException("Strategy is not set. Please set the strategy before executing.");
        }
		graphCreatorStrat.fill(this, nodes, maxWeight, file);
		calculateTotalWeight();
	}
	
	private void calculateTotalWeight(){
		this.W=0;
		int nodes = this.getNodeCount();
		for(int source=1; source<=nodes; source++){
			for(int dest=source+1; dest<=nodes; dest++){
				if(hasEdge(source, dest))
					this.W+=getEdge(source, dest).intValue();
			}
		}
	}

	public int getW() {
		return W;
	}
	
    // This function prints the adjancency list of each node.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		Set<Integer> nodes = getNodes();
		for( Integer source : nodes){
			for(Integer destination : nodes){
				builder.append(hasEdge(source, destination) ? getEdge(source, destination).toString() : "0");
				builder.append(" ");
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
