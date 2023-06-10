package graph;

import java.util.*;

public class GraphGeneratorStrategy implements IGraphFillStrategy{

    @Override
    public void fill(WeightGraph graph, Integer nodes, Integer maxWeight, String file) {
        Random rand = new Random();
        ArrayList<SortedSet<Integer>> array = createEdges(nodes, 0.5);
        
        for (SortedSet<Integer> edge : array) {
            // Get nodes
            Integer nodeA = edge.first();
            Integer nodeB = edge.last();

            // Generate weight between 1 and maxWeight
            int weight = rand.nextInt(maxWeight) + 1;

            // Add edge to the graph
            graph.addEdge(nodeA, nodeB, weight);
        }

        
    }

    private ArrayList<SortedSet<Integer>> createEdges(Integer size, Double edgePercentage){
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<SortedSet<Integer>> edges = new ArrayList<>();

        // Generate a shuffled sequence of numbers from 1 to size
        for (Integer node = 1; node <= size; node++) {
            array.add(node);
        }
        Collections.shuffle(array);

        // Add first element to the end to create a cycle
        array.add(array.get(0));

        // Add pairs as edges
        for (int i=0; i<size; i++){
            SortedSet<Integer> edge = new TreeSet<>();
            edge.add(array.get(i));
            edge.add(array.get(i+1));
            edges.add(edge);
        }

        // Generate all possible edges except those already present in the edges list
        ArrayList<SortedSet<Integer>> otherEdges = new ArrayList<>();
        for(Integer source=0; source<size; source++){
            for(Integer dest=source+1; dest<size; dest++){
                SortedSet<Integer> edge = new TreeSet<>();
                edge.add(source);
                edge.add(dest);
                
                if(!edges.contains(edge)){
                    otherEdges.add(edge);
                }
            }
        }
        
        // Picks from otherEdges and adds them to edges
        Random rand = new Random();
        int amount = (int) ((Math.floor((edges.size()+otherEdges.size())*edgePercentage))-edges.size());
        for(int i=0; i<amount; i++){
            // Pick an edge
            int pick = rand.nextInt(otherEdges.size());

            // Move it from otherEdges to edges
            edges.add(otherEdges.get(pick));
            otherEdges.remove(pick);
        }
        return edges;
    }

    
}
