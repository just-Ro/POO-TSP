package simulation;
import java.util.Map;

import graph.*;

public class WeightGraph extends AGraph<Integer,Integer>{
    // ro ?? are you here?? T_T º.º ._. bom dia


    // Prints the adjancency list of each vertex.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (Integer v : map.keySet()) {
			builder.append(v.toString()).append(": ");
			Map<Integer, Integer> adjacentVertices = map.get(v);
            
			for (Integer w : adjacentVertices.keySet()) {
				builder.append(w.toString()).append(" ");
			}
			builder.append("\n");
		}

		return builder.toString();
	}
}
