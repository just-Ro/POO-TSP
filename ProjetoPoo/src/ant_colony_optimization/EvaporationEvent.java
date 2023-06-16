package ant_colony_optimization;

import simulation.AEvent;
import static rand.myMath.expRandom;

/**
 * The EvaporationEvent class represents an event in which pheromone evaporation occurs in an ant colony optimization algorithm.
 * It is responsible for updating the pheromone levels on a specific edge in the pheromone graph.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class EvaporationEvent extends AEvent implements IEvaporationEvent{

    private double eta, rho;
    private int source, dest;
    private PheroGraph pGraph;
    private boolean isvalid = true;
    private Colony col;

    /**
     * Constructs a new EvaporationEvent with the specified parameters.
     *
     * @param time     the time of the event
     * @param eta      the eta value used for exponential randomization
     * @param rho      the rho value representing the pheromone evaporation rate
     * @param source   the source node of the pheromone edge
     * @param dest     the destination node of the pheromone edge
     * @param pGraph   the PheroGraph representing the pheromone graph
     */
    public EvaporationEvent(double time, double eta, double rho, int source, int dest, PheroGraph pGraph, Colony col){
        super(time);
        this.eta = eta;
        this.rho = rho;
        this.dest = dest;
        this.source = source;
        this.pGraph = pGraph;
        this.col = col;
        //System.out.printf("\nEvento de evaporacao criado! %.4f\n", eventTime);
        //System.out.println("s e d: " + source + " " + dest);
        this.eventTime += expRandom(eta);
    }

    @Override
    public void handleEvent() {
        col.incrementEevent();
        //System.out.println("oi evap: " + this.eventTime);
        //System.out.printf("Evaporou! %.2f\n", eventTime);
        //System.out.println("Quantas pheros antes: " + this.pGraph.getEdge(source, dest));
        //System.out.println("s e d: " + source + " " + dest);

        this.pGraph.updateEdge(source, dest, (-this.rho));
        this.eventTime += expRandom(eta);
        //System.out.println("prox evap: " + this.eventTime);
        //System.out.println("Quantas pheros depois: " + this.pGraph.getEdge(source, dest) + "\n");
        //System.out.println(pGraph);

        if(this.pGraph.getEdge(source, dest) == 0.0){
            this.isvalid = false;
        }

    }

    @Override
    public boolean valid() {
        return this.isvalid;
    }

}

