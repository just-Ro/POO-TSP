package ant_colony_optimization;

import java.util.Set;

import graph.AGraph;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
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
