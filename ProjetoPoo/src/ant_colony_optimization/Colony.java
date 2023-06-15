package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import graph.WeightedGraph;


public class Colony {
    public List<Ant> ants;
    private WeightedGraph graph;
    private PheroGraph phero;
    private double alpha, beta, gama, eta, rho;
    private int nestNode, nodes, colonySize;

    public Colony(WeightedGraph graph, int colonySize, int nestNode, int nodes, double alpha, double beta, double gama, double eta, double rho){
        
        // initialized by reference
        this.graph=graph;
        this.phero = new PheroGraph(true);
        
        // Isto
        //this.ants = new ArrayList<Ant>(Collections.nCopies(colonySize, new Ant(nestNode, this.graph, this.phero, this)));
        
        this.colonySize=colonySize;
        this.nestNode=nestNode;
        this.nodes = nodes;
        this.alpha = alpha;
        this.beta = beta;

        this.ants = new ArrayList<Ant>();
        for(int i=0; i<colonySize; i++){
            this.ants.add(i, new Ant(this.nestNode, this.graph, this.phero, this));
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

    protected double getGama(){
        return this.gama;
    }

    protected int getNodes(){
        return this.nodes;
    }

    protected double getEta(){
        return this.eta;
    }

    protected double getRho(){
        return this.rho;
    }

}
