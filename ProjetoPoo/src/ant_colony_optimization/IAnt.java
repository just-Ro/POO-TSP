package ant_colony_optimization;

import java.util.List;

import simulation.IEvent;
/**
 * The IAnt interface represents an ant in an ant colony optimization algorithm.
 * Ants are autonomous agents that traverse the graph, leaving pheromone trails and making decisions based on the pheromone levels and heuristic information.
 * This interface defines methods for performing travel actions, retrieving information about the ant, and updating the pheromone graph.
 * By implementing this interface, custom ant classes can participate in the ant colony optimization process.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see Ant
 */
public interface IAnt {

    /**
     * Returns a string representation of the Ant object.
     *
     * @return The string representation of the Ant object.
     */
    String toString();

    /**
     * Performs a travel action for the Ant.
     *
     * @param eventTime The event time for the travel action.
     * @param newEvents The list of new events to be added.
     */
    void travel(double eventTime, List<IEvent> newEvents);

    /**
     * Retrieves the name of the Ant.
     *
     * @return The name of the Ant.
     */
    String getAntName();

    /**
     * Retrieves the current node of the Ant.
     *
     * @return The current node of the Ant.
     */
    int getCurrentNode();

    /**
     * Retrieves the path of the Ant.
     *
     * @return The path of the Ant.
     */
    Path getPath();

    /**
     * Retrieves the next node for the Ant to travel.
     *
     * @return The next node for the Ant to travel.
     */
    int nextNode();

    /**
     * Retrieves the pheromone update value for the Ant.
     *
     * @return The pheromone update value for the path's edges.
     */
    double pheroUpdateValue();

    /**
     * Updates the PheroGraph with the pheromone values.
     */
    void updatePheroGraph();

    /**
     * Retrieves the weight of the edge between the current node and the next node.
     *
     * @return The weight of the edge.
     */
    int edgeWeight();

}