package ant_colony_optimization;

/**
 * This interface represents a Pair of values.
 * It defines methods to update and retrieve the first and second values of the pair.
 * 
 * @author João Mateus
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see Pair
 */
public interface IPair{
    /**
     * Updates the values of the Pair.
     * @param fnew the new value for the first element of the Pair
     * @param snew the new value for the second element of the Pair
     */
    void update(String fnew, Path snew);

    /**
     * Updates the first value of the Pair.
     * @param fnew the new value for the first element of the Pair
     */
    void updateFirst(String fnew);

    /**
     * Updates the second value of the Pair.
     * @param snew the new value for the second element of the Pair
     */
    void updateSecond(Path snew);

    /**
     * Retrieves the first value of the Pair.
     * @return the first value of the Pair
     */
    String getFirst();

    /**
     * Retrieves the second value of the Pair.
     * @return the second value of the Pair
     */
    Path getSecond();

    /**
     * Retrieves the weight of the Pair's second value.
     * @return the weight of the Pair's second value
     */
    int getWeight();
}