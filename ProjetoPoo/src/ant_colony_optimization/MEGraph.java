package ant_colony_optimization;

import java.util.*;

import graph.IMEgraph;

/*
 *  Modifying edges graph
 */
public class MEGraph extends IMEgraph<Integer, Double> {
    private Map<Integer, Map<Integer, Double>> pheromonesMap;

    public MEGraph(boolean bidirectional) {
        super(bidirectional);
        pheromonesMap = new HashMap<>();
    }

    @Override
    public Double getModValue(Integer source, Integer destination) {
        if (pheromonesMap.containsKey(source)) {
            Map<Integer, Double> destinationMap = pheromonesMap.get(source);
            if (destinationMap.containsKey(destination)) {
                return destinationMap.get(destination);
            }
        }
        return null;
    }

    @Override
    public void setModValue(Integer source, Integer destination, Double value) {
        pheromonesMap.computeIfAbsent(source, k -> new HashMap<>()).putIfAbsent(destination, value);
    }

    @Override
    public void updateModValue(Integer source, Integer destination, Double value){
        if(pheromonesMap.containsKey(source)){
            if(pheromonesMap.get(source).containsKey(destination))
                pheromonesMap.get(source).put(destination, pheromonesMap.get(source).get(destination) + value);
        }
    }
}