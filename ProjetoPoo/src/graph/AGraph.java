package graph;

import java.util.*;

public abstract class AGraph<N,E> implements IGraph<N, E> {

	// We use Hashmap to store the edges in the graph
	protected Map<N, Map<N, E> > map;
	private boolean bidirectional = false;

	public AGraph(boolean bidirectional){
		this.bidirectional = bidirectional;
		this.map = new HashMap<>();
	}

	// This function adds a new node to the graph
	@Override
	public void addNode(N node){
		this.map.put(node, new HashMap<N,E>());
	}

	// This function adds the edge from source to destination
	@Override
	public void addEdge(N source, N destination, E edge){

		if (!this.map.containsKey(source))
			addNode(source);

		if (!this.map.containsKey(destination))
			addNode(destination);

		setEdge(source, destination, edge);
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
		for (N v : this.map.keySet()) {
			count += getEdgeCount(v);
		}
		if (this.bidirectional == true) {
			count = count / 2;
		}
		return count;
	}

	// This function gives the count of edges connected to a specific node
	@Override
	public int getEdgeCount(N v){
		return this.map.get(v).size();
	}

	// This function gives whether a node is present or not
	@Override
	public boolean hasNode(N node){
		return this.map.containsKey(node);
	}

	// This function gives whether an edge is present or not
	@Override
	public boolean hasEdge(N source, N destination){
		return this.map.get(source).containsKey(destination);
	}

	// This function gives a set of all nodes
	@Override
	public Set<N> getNodes(){
		return this.map.keySet();
	}

	// This function gives the set of nodes adjacent to a particular node
	@Override
	public Set<N> getNeighbours(N v){
		return this.map.get(v).keySet();
	}

	// This function gives the edge present from source to destination or null if no edge found
	@Override
	public E getEdge(N source, N destination){
		if(hasEdge(source, destination))
			return this.map.get(source).get(destination);
		else
			return null;
	}

	// This function updates the edge from source to destination
	@Override
	public void setEdge(N source, N destination, E edge) {
		this.map.get(source).put(destination, edge);
		if (this.bidirectional == true) {
			this.map.get(destination).put(source, edge);
		}
	}
}
