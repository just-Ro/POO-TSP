package ant_colony_optimization;

/**
 * The Path interface represents a path in a weighted graph.
 * It provides methods to manipulate and calculate properties of the path.
 * 
 * @author João Mateus
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public interface IPath {
    
    /**
     * Creates a deep copy of the path.
     * @return a copy of the path
     */
    IPath copy();

    /**
     * Clears the path by removing all elements starting from the end and stopping at the specified index.
     * The element at the specified index is also removed.
     * If the specified index is not valid, the entire path is cleared.
     * @param index the stopping index
     */
    void clearUntil(int index);
    
    /**
     * Calculates the weight of the path based on the edges in the associated weighted graph.
     * @return the weight of the path
     */
    int pathWeight();
    
    /**
     * Clears the path by removing elements between the specified from and to indices.
     * The element at the from index is included, but the element at the to index is excluded.
     * If the from or to indices are not valid, the path remains unchanged.
     *
     * @param from the index to start clearing from (inclusive)
     * @param to the index to stop clearing at (exclusive)
     * @return the new size of the path after clearing
     */
    int clearPath(int from, int to);

    /**
     * Inverts the order of elements in the path.
     * @return the inverted path
     */
    Path invertPath(Path path);
    
    /**
     * Checks if the path is equal to another path.
     * Two paths are considered equal if they have the same elements in the same order.
     * @param other the path to compare with
     * @return true if the paths are equal, false otherwise
     */
    boolean equals(Path other);
    
    // Additional methods specific to your implementation can be added here
    
    // For example:
    
    /**
     * Adds an element to the end of the path.
     * @param element the element to be added
     */
    void addElement(int element);
    
    /**
     * Returns the element at the specified index in the path.
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    int getElement(int index);
    
    // Note: This interface assumes that the underlying implementation extends ArrayList<Integer>
}