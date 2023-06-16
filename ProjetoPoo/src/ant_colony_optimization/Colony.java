package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import graph.WeightedGraph;

/**
 * The Colony class represents a colony of ants in an ant colony optimization algorithm.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Colony implements IColony{
    public List<Ant> ants;
    private TreeSet<Pair> scoreBoard;
	private WeightedGraph graph;
    private PheroGraph phero;
    private double alpha, beta, gama, eta, rho;
    private int nestNode, nodes, colonySize;
    //Number of Move Events
    public int mevents = 0;
    //Number of Evaporation Events
    public int eevents = 0;


    /**
     * Constructs a Colony object with the specified parameters.
     *
     * @param graph      the weighted graph representing the environment
     * @param colonySize the size of the colony (number of ants)
     * @param nestNode   the node where the colony's nest is located
     * @param nodes      the total number of nodes in the graph
     * @param alpha      the alpha parameter for ant decision-making
     * @param beta       the beta parameter for ant decision-making
     * @param gama       the gama parameter for pheromone updates
     * @param eta        the eta parameter for pheromone updates
     * @param rho        the rho parameter for pheromone updates
     */
    public Colony(WeightedGraph graph, int colonySize, int nestNode, int nodes, double alpha, double beta, double gama, double eta, double rho){
        
        this.graph=graph;
        this.phero = new PheroGraph(true);
        
        this.colonySize=colonySize;
        this.nestNode=nestNode;
        this.nodes = nodes;
        this.alpha = alpha;
        this.beta = beta;
        this.eta = eta;
        this.rho = rho;
        this.gama = gama;

        this.ants = new ArrayList<Ant>();
        for(int i=0; i<colonySize; i++){
            this.ants.add(i, new Ant(this.nestNode, this.graph, this.phero, this));
        }

        this.scoreBoard = new TreeSet<>(new PairComparator());
    }

    // nao pode ter todos os caminhos iguais se ja tiver caminhos iguais n poe no score
    public void updateScoreBoard(Pair pair){
        scoreBoard.add(pair);
        if(scoreBoard.size() > 6) scoreBoard.pollLast();
    }

    @Override
    public int getColonySize(){
        return this.colonySize;
    }

    @Override
    public double getNestNode(){
        return this.nestNode;
    }
    
    @Override
    public double getAlpha(){
        return this.alpha;
    }

    @Override
    public double getBeta(){
        return this.beta;
    }

    @Override
    public double getGama(){
        return this.gama;
    }

    @Override
    public int getNodes(){
        return this.nodes;
    }

    @Override
    public double getEta(){
        return this.eta;
    }

    @Override
    public double getRho(){
        return this.rho;
    }
    
    @Override
    public TreeSet<Pair> getScoreBoard() {
		return scoreBoard;
	}

    @Override
    public void incrementEevent (){
        this.eevents++;
    }

    @Override
    public void incrementMevent(){
        this.mevents++;
    }

    @Override
    public int getMevents() {
        return mevents;
    }

    @Override
    public int getEevents() {
        return eevents;
    }

}

class PairComparator implements Comparator<Pair>{

    @Override
    public int compare(Pair p1, Pair p2) {
        int i = Integer.compare(p1.getSecond().pathWeight(), p2.getSecond().pathWeight());
        //Dont return 0, so that TreeSet can have more than 1 Pair with the same path Weight
        if (i == 0) i = -1;
        //Return 0 if they are the same path (dont add to the treeSet)
        boolean equal = (p1.getSecond()).equals(p2.getSecond());
        if (equal) return 0;
        return i; 
    }
    
}
