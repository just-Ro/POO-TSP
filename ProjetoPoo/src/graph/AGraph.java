package graph;

// Java program to implement Graph
// with the help of Generics

import java.util.*;

public class AGraph<T> {

	// We use Hashmap to store the edges in the graph
	private Map<T, List<T> > map = new HashMap<>();

	// This function adds a new vertex to the graph
	public void addVertex(T s){
		map.put(s, new LinkedList<T>());
	}

	// This function adds the edge between source to destination
	public void addEdge(T source, T destination, boolean bidirectional){

		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).add(destination);
		if (bidirectional == true) {
			map.get(destination).add(source);
		}
	}

	// This function gives the count of vertices
	public int getVertexCount(){
		return map.keySet().size();
	}

	// This function gives the count of edges
	public int getEdgeCount(boolean bidirection){
		int count = 0;
		for (T v : map.keySet()) {
			count += map.get(v).size();
		}
		if (bidirection == true) {
			count = count / 2;
		}
		return count;
	}

	// This function gives whether a vertex is present or not.
	public boolean hasVertex(T s){
		return map.containsKey(s);
	}

	// This function gives whether an edge is present or not.
	public boolean hasEdge(T s, T d){
		return map.get(s).contains(d);
	}

	// Prints the adjancency list of each vertex.
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();

		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			for (T w : map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}

		return (builder.toString());
	}
}
