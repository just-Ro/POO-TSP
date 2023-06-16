package graph;

import java.util.Collections;
import java.util.ArrayList;
import rand.CustomRandom;
import rand.RandomSingleton;

/**
 * The GraphGeneratorStrategy class implements the IGraphCreationStrategy interface
 * and provides a strategy for generating a weighted graph.
 */
public class GraphGeneratorStrategy implements IGraphCreationStrategy{

    @Override
    public void fill(WeightedGraph graph, int nodes, int maxWeight, String file) {
        CustomRandom rand = RandomSingleton.getInstance();
        

        // Generate Hamiltonian path
        ArrayList<Integer> array = new ArrayList<>();
        for (int node = 1; node <= nodes; node++) {
            array.add(node);
        }
        Collections.shuffle(array);
        
        // Add first element to the end to create a cycle
        array.add(array.get(0));

        // Handles graph with 1 node
        graph.addNode(array.get(0));
        if(array.size() < 2) return;

        // Add pairs as edges
        for (int i=0; i<nodes; i++){
            graph.addEdge(array.get(i), array.get(i+1), rand.nextInt(maxWeight)+1); // 1->maxWeight
        }
        
        int maxEdges = (nodes*nodes - nodes)/2;
        int goalOfExtraEdges = rand.nextInt(Math.max(maxEdges - nodes, 0));
        int extraEdges = 0;

        // Handles graphs with 2 and 3 nodes
        if(goalOfExtraEdges == 0) return;

        // Generate all possible edges with random weights
        while(extraEdges < goalOfExtraEdges){
            int source = rand.nextInt(nodes)+1; // 1->nodes
            int dest = rand.nextInt(nodes)+1; // 1->nodes
            if(source == dest) continue;

            if(!graph.hasEdge(source, dest)){
                int weight = rand.nextInt(maxWeight)+1; // 1->maxWeight
                graph.addEdge(source, dest, weight);
                extraEdges++;
            }

        }
    }


    
}
