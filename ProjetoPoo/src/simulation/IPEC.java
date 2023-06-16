package simulation;

/**
 * 
 * Pending Event Container.
 * A set of events, sorted by time
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 *
 * 
 */
public interface IPEC {

    /**This function adds a given Event to the pec
     * @param ev Event to be added
     */
    void addEventPEC(IEvent ev);

    /**This function gets the next event from pec
     * Also removes that event from pec
     * @return the next event
     */
    IEvent nextEventPEC();

    /** This function checks if the PEC is empty
     * @return true if it's is empty
     */
    boolean isEmpty();

}