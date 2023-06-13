package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import graph.IGraph;
import graph.WeightGraph;


public class Colony {
    public List<Ant> ants;
    private WeightGraph graph;
    private PheroGraph phero;
    private double alpha, beta, gama, eta, rho;
    private int nestNode, nodes, colonySize;
    private int totalWeight=0;

    public Colony(WeightGraph graph, int colonySize, int nestNode, int nodes, double alpha, double beta, double gama, double eta, double rho){
        
        // initialized by reference
        this.graph=graph;
        this.phero = new PheroGraph(true);
        
        // Isto
        this.ants = new ArrayList<Ant>(Collections.nCopies(colonySize, new Ant(nestNode, this.graph, this.phero, this)));

        this.colonySize=colonySize;
        this.nestNode=nestNode;
        this.nodes = nodes;
        this.alpha = alpha;
        this.beta = beta;
        for(int source=1; source<nodes; source++){
            for(int dest=0; dest<=source; dest++){
                this.totalWeight+=graph.getEdge(source, dest);
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

    protected double getGama(){
        return this.gama;
    }

    protected int getNodes(){
        return this.nodes;
    }

    protected int getTotalWeight(){
        return this.totalWeight;
    }

    protected double getEta(){
        return this.eta;
    }

    protected double getRho(){
        return this.rho;
    }

}
