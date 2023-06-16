package ant_colony_optimization;

import java.util.TreeSet;

/**
 * The IColony interface represents a colony in an ant colony optimization algorithm.
 * It defines methods for updating the score board, retrieving colony properties, and accessing the score board.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see Colony
 */
public interface IColony {

    /**
     * Updates the score board with the given pair.
     *
     * @param pair the pair to be added to the score board
     */
    void updateScoreBoard(Pair pair);

    /**
     * Returns the size of the colony.
     *
     * @return the size of the colony
     */
    int getColonySize();

    /**
     * Returns the nest node of the colony.
     *
     * @return the nest node of the colony
     */
    double getNestNode();

    /**
     * Returns the alpha value of the colony.
     *
     * @return the alpha value of the colony
     */
    double getAlpha();

    /**
     * Returns the beta value of the colony.
     *
     * @return the beta value of the colony
     */
    double getBeta();

    /**
     * Returns the gamma value of the colony.
     *
     * @return the gamma value of the colony
     */
    double getGama();

    /**
     * Returns the number of nodes in the colony.
     *
     * @return the number of nodes in the colony
     */
    int getNodes();

    /**
     * Returns the eta value of the colony.
     *
     * @return the eta value of the colony
     */
    double getEta();

    /**
     * Returns the rho value of the colony.
     *
     * @return the rho value of the colony
     */
    double getRho();

    /**
     * Returns the score board of the colony.
     *
     * @return the score board of the colony
     */
    TreeSet<Pair> getScoreBoard();

    /**
     * Increments the count of Evaporation events.
     */
    void incrementEevent();
    
    /**
     * Increments the count of Move events.
     */
    void incrementMevent();
    
    /**
     * Retrieves the count of Move events.
     * @return the count of Move events
     */
    int getMevents();
    
    /**
     * Retrieves the count of Evaporation events.
     * @return the count of Evaporation events
     */
    int getEevents();
}