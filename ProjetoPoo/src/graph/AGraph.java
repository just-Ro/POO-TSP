package graph;

import java.util.*;

public class AGraph<T,E> implements IGraph<T, E> {

	// We use Hashmap to store the edges in the graph
	private Map<T, Map<T, E> > map = new HashMap<>();
	private boolean bidirectional = false;

	public AGraph(boolean bidirectional){
		this.bidirectional = bidirectional;
	}

	// This function adds a new node to the graph
	@Override
	public void addNode(T node){
		this.map.put(node, new HashMap<T,E>());
	}

	// This function adds the edge between source to destination
	@Override
	public void addEdge(T source, T destination, E edge){

		if (!this.map.containsKey(source))
			addNode(source);

		if (!this.map.containsKey(destination))
			addNode(destination);

		this.map.get(source).put(destination, edge);
		if (this.bidirectional == true) {
			this.map.get(destination).put(source, edge);
		}
	}

	// This function gives the count of nodes
	@Override
	public int getNodeCount(){
		return this.map.keySet().size();
	}

	// This function gives the total count of edges
	@Override
	public int getEdgeCount(){
		int count = 0;
		for (T v : this.map.keySet()) {
			count += getEdgeCount(v);
		}
		if (this.bidirectional == true) {
			count = count / 2;
		}
		return count;
	}

	// This function gives the count of edges connected to a specific node
	@Override
	public int getEdgeCount(T v){
		return this.map.get(v).size();
	}

	// This function gives whether a node is present or not
	@Override
	public boolean hasNode(T node){
		return this.map.containsKey(node);
	}

	// This function gives whether an edge is present or not
	@Override
	public boolean hasEdge(T source, T destination){
		return this.map.get(source).containsKey(destination);
	}

	// This function gives a set of all nodes
	public Set<T> getNodes(){
		return this.map.keySet();
	}

	// This function gives the set of nodes adjacent to a particular node
	public Set<T> getNeighbours(T v){
		return this.map.get(v).keySet();
	}

	// This function gives the edge present from source to destination or null if no edge found
	public E getEdge(T source, T destination){
		if(hasEdge(source, destination))
			return this.map.get(source).get(destination);
		else
			return null;
	}
}
