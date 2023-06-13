package ant_colony_optimization;

import java.util.Set;

import graph.AGraph;

/*
 *  Modifying edges graph
 */
public class PheroGraph extends AGraph<Integer, Double> {
/*
# Comentários do feijão
		
	 I
	 A
Iw W   P Ip

I 
A implements I 

Iw extends I 
w extends A implements Iw

api
	graph
		I
		Iw
		Ip
	simulation
		....

impl
	graph
		...
	simulation
		...
	aco

*/
    public PheroGraph(boolean bidirectional) {
        super(bidirectional);
    }

    // This function updates an edge by adding a value to it
    public void updateEdge(int source, int destination, double value){
        if(hasEdge(source, destination)){
            setEdge(source, destination, getEdge(source, destination) + value);
        }
    }

    // This function prints the adjancency list of each node.
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
				builder.append(String.format("%.2f", getEdge(source, destination)));
				builder.append(") ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
