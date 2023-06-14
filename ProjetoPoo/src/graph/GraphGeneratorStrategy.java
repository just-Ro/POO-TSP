package graph;

import java.util.Collections;
import java.util.ArrayList;
import rand.CustomRandom;
import rand.RandomSingleton;


public class GraphGeneratorStrategy implements IGraphCreationStrategy{

    @Override
    public void fill(WeightedGraph graph, int nodes, int maxWeight, String file) {
        CustomRandom rand = RandomSingleton.getInstance();
        
        // Generate all possible edges with random weights
        for(int source=1; source<=nodes; source++){
            for(int dest=source+1; dest<=nodes; dest++){
                int weight = rand.nextInt(maxWeight+1); // 0->maxWeight

                if(weight>0){
                    graph.addEdge(source, dest, weight);
                }
            }
        }

        // Generate Hamiltonian path
        ArrayList<Integer> array = new ArrayList<>();
        for (int node = 1; node <= nodes; node++) {
            array.add(node);
        }
        Collections.shuffle(array);
        
        // Add first element to the end to create a cycle
        array.add(array.get(0));

        // Add pairs as edges
        for (int i=0; i<nodes; i++){
            graph.addEdge(array.get(i), array.get(i+1), rand.nextInt(maxWeight)+1); // 1->maxWeight
        }
    }


    
}
