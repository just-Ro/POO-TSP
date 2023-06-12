package ant_colony_optimization;

import java.util.ArrayList;
import java.util.List;

import graph.WeightGraph;


public class Colony {
    public List<Ant> ants;
    private WeightGraph graph;
    private PheroGraph phero;

    public Colony(double colonySize, int nestNode, WeightGraph graph, PheroGraph phero){
        this.ants = new ArrayList<Ant>();
        
        // initialized by reference
        this.graph=graph;
        this.phero=phero;

        for(int i=0;i<colonySize;i++){
            ants.add(new Ant(nestNode, this.graph, this.phero));
        }
    }
}
