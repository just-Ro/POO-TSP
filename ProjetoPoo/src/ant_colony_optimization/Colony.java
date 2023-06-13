package ant_colony_optimization;

import java.util.ArrayList;
import java.util.List;

import graph.WeightGraph;


public class Colony {
    public List<Ant> ants;
    private WeightGraph graph;
    private PheroGraph phero;
    private double alpha, beta;
    private int nestNode, nodes, colonySize;
    private int totalWeight;

    public Colony(WeightGraph graph, int colonySize, int nestNode, int nodes, double alpha, double beta){
        this.ants = new ArrayList<Ant>();
        
        // initialized by reference
        this.graph=graph;
        this.phero = new PheroGraph(true);

        for(int i=0;i<colonySize;i++){
            ants.add(new Ant(nestNode, this.graph, this.phero));
        }
        this.colonySize=colonySize;
        this.nestNode=nestNode;
        this.nodes = nodes;
        this.alpha = alpha;
        this.beta = beta;
        for(int i=1; i<nodes; i++){
            for(int j=0; j<=i; j++){
                totalWeight=graph.getEdge(i, j);
            }
        }
    }

    protected int getColonySize(){
        return this.colonySize;
    }

    protected double getNestNode(){
        return this.nestNode;
    }
    
    protected double getAlpha(){
        return this.alpha;
    }

    protected double getBeta(){
        return this.beta;
    }

    protected int getNodes(){
        return this.nodes;
    }
    
}
