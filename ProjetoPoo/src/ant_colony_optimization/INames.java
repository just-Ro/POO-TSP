package ant_colony_optimization;

/**
 * Provides an interface for managing names.
 * 
 * @author João Mateus
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see Names
 */
public interface INames {
    /**
     * Sets a new name.
     *
     * @return a random name.
     */
    String nextName();
}