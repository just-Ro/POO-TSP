package graph;

import java.util.*;

public class GenerateGraphStrategy implements IGraphFillStrategy{

    @Override
    public void fill(WeightGraph graph, Integer nodes, Integer maxWeight, String file) {
        Random rand = new Random();
        ArrayList<Integer> array = makeHamiltonianCycle(nodes);

        int nodeA, nodeB;

        for (int i = 0; i < nodes; i++) {
            nodeA = array[i];
            nodeB = array[i + 1];
            int edgeValue = rand.nextInt(maxWeight) + 1; // Generate a random value between 0 and 9 for the edge
            this.matrix[nodeA][nodeB].weight = edgeValue;
            this.matrix[nodeB][nodeA].weight = edgeValue; // Since the graph is undirected, assign the same value for the reverse edge
        }

        int additionalEdges = (int) (nodes / 3);
        for (int i = 0; i < additionalEdges; i++) {
            nodeA = rand.nextInt(nodes) + 1;
            nodeB = rand.nextInt(nodes) + 1;
            int edgeValue = rand.nextInt(maxWeight) + 1; // Generate a random value between 1 and maxEdgeWeight
            if (this.matrix[nodeA][nodeB].weight == 0 && this.matrix[nodeB][nodeA].weight == 0) {
                this.matrix[nodeA][nodeB].weight = edgeValue;
                this.matrix[nodeB][nodeA].weight = edgeValue; // Since the graph is undirected, assign the same value for the reverse edge
            } else {
                i--; // Retry adding an edge since there was already an edge present
            }
        }
    }

    private ArrayList<Integer> makeHamiltonianCycle(Integer size){
        ArrayList<Integer> array = new ArrayList<Integer>(0);
        for (int i = 0; i < size; i++) {
            array.add(i+1);
        }


        return array;
    }
    
}
