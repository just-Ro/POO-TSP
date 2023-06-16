package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import graph.WeightedGraph;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Colony{
    public List<Ant> ants;
    //public ArrayList<Pair> scoreBoard;
    //public SortedSet<Pair> scoreBoard;
    private TreeSet<Pair> scoreBoard;
	private WeightedGraph graph;
    private PheroGraph phero;
    private double alpha, beta, gama, eta, rho;
    private int nestNode, nodes, colonySize;

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

        //this.scoreBoard = new TreeSet<>(Comparator.comparingInt(Pair::getWeight));
        this.scoreBoard = new TreeSet<>(new PairComparator());
    }

    // nao pode ter todos os caminhos iguais se ja tiver caminhos iguais n poe no score
    public void updateScoreBoard(Pair pair){
        scoreBoard.add(pair);
        if(scoreBoard.size() > 5) scoreBoard.pollLast();


        /* for(int i=0; i<5; i++){
            // checks for unused slots in the score board
            if(scoreBoard.get(i).getFirst()==null){
                scoreBoard.get(i).update(ant.getAntName(),ant.getPath());
            }
            // checks for equal paths
            if(scoreBoard.get(i).getSecond().equals(ant.getPath())){
                return 0; // º.º
            }
        }
        for(int i=0; i<5; i++){
            // compares path weights
            if(ant.pathWeight() < scoreBoard.get(i).getSecond().pathWeight()){
                for(int j=5; j>i; j--){
                    scoreBoard.get(j).updateSecond(scoreBoard.get(j-1).getSecond());
                }
                break;
            }
        } */
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
    
    public TreeSet<Pair> getScoreBoard() {
		return scoreBoard;
	}

}

class PairComparator implements Comparator<Pair>{

    @Override
    public int compare(Pair p1, Pair p2) {
        int i = Integer.compare(p1.getSecond().pathWeight(), p2.getSecond().pathWeight());
        if (i == 0) i = -1;
        boolean equal = (p1.getSecond()).equals(p2.getSecond());
        if (equal) return 0;
        return i; 

        /*
        o que é considerado igual:
        
        diferente:
        
         */
    }
    
}
