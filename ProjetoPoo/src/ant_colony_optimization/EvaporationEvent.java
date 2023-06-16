package ant_colony_optimization;

import simulation.AEvent;
import static rand.myMath.expRandom;

/**
 * The EvaporationEvent class represents an event in which pheromone evaporation occurs in an ant colony optimization algorithm.
 * It is responsible for updating the pheromone levels on a specific edge in the pheromone graph, reducing the value of pheromones by rho.
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
        this.eventTime += expRandom(eta);
    }

    @Override
    public void handleEvent() {
        col.incrementEevent();
        //Updates edge value, decrementing rho
        this.pGraph.updateEdge(source, dest, (-this.rho));
        //Sets up the eventTime for the next Evaporation Event
        this.eventTime += expRandom(eta);
        //If edge value is 0, make the Event invalid
        if(this.pGraph.getEdge(source, dest) == 0.0){
            this.isvalid = false;
        }

    }

    @Override
    public boolean valid() {
        return this.isvalid;
    }

}

