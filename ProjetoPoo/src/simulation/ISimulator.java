package simulation;

/**
 * Simulator that simulates events using a PEC
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public interface ISimulator {
    /**
     * This function runs the Simulator
     */
    public void run();

    /** This function adds events to the PEC of the Simulator
     * @param event Event to add
     */
    public void addToPEC(IEvent event);
}
