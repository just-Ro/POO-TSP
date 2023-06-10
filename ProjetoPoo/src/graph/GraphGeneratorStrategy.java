package graph;

import java.util.*;

public class GraphGeneratorStrategy implements IGraphFillStrategy{

    @Override
    public void fill(WeightGraph graph, Integer nodes, Integer maxWeight, String file) {
        Random rand = new Random();
        
        // Generate all possible edges with random weights
        for(Integer source=0; source<nodes; source++){
            for(Integer dest=source+1; dest<nodes; dest++){
                int weight = rand.nextInt(maxWeight+1); // 0->maxWeight

                if(weight>0){
                    graph.addEdge(source, dest, weight);
                }
            }
        }

        // Generate Hamiltonian path
        ArrayList<Integer> array = new ArrayList<>();
        for (Integer node = 1; node <= nodes; node++) {
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
