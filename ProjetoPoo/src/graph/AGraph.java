package graph;

// Java program to implement Graph
// with the help of Generics

import java.util.*;

public class AGraph<T,E> implements IGraph<T, E> {

	// We use Hashmap to store the edges in the graph
	private Map<T, Map<T, E> > map = new HashMap<>();
	boolean bidirectional = false;

	public AGraph(boolean bidirectional){
		this.bidirectional = bidirectional;
	}

	// This function adds a new vertex to the graph
	@Override
	public void addVertex(T vertex){
		map.put(vertex, new HashMap<T,E>());
	}

	// This function adds the edge between source to destination
	@Override
	public void addEdge(T source, T destination, E edge){

		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).put(destination, edge);
		if (this.bidirectional == true) {
			map.get(destination).put(source, edge);
		}
	}

	// This function gives the count of vertices
	@Override
	public int getVertexCount(){
		return map.keySet().size();
	}

	// This function gives the total count of edges
	@Override
	public int getEdgeCount(){
		int count = 0;
		for (T v : map.keySet()) {
			count += getEdgeCount(v);
		}
		if (this.bidirectional == true) {
			count = count / 2;
		}
		return count;
	}

	// This function gives the count of edges connected to a specific vertex
	@Override
	public int getEdgeCount(T v){
		return map.get(v).size();
	}

	// This function gives whether a vertex is present or not.
	@Override
	public boolean hasVertex(T vertex){
		return map.containsKey(vertex);
	}

	// This function gives whether an edge is present or not.
	@Override
	public boolean hasEdge(T source, T destination){
		return map.get(source).containsKey(destination);
	}

}
