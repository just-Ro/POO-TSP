package simulation;

import java.util.List;

/**
 * <p>The Simulator class implements the ISimulator interface and represents a simulation engine. </p>
 * <p>It manages the simulation time, current event, and the Priority Event Container (PEC) where events are stored.
 * The Simulator runs the simulation by continuously processing events until the PEC is empty or the simulation time limit is reached.</p>
 * 
 * <p>Note: The actual implementation of the IEvent and IPEC interfaces are not shown here.
 * The Simulator class assumes that the IEvent and IPEC interfaces and their implementing classes exist and have appropriate functionality.</p>
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Simulator implements ISimulator{
    
    private IPEC pec;
    private double simulationTime;
    private IEvent currentEvent;
    private double currentTime;
    
    /**
     * Constructs a new Simulator object with the specified final instant of the simulation.
     *
     * @param finalInstant the final instant of the simulation
     */
    public Simulator(double finalInstant){
        this.simulationTime = finalInstant;
        this.currentTime = 0;
        this.pec = new PEC();
    }
    
    @Override
    public void run(){
        while(!pec.isEmpty() && this.currentTime < this.simulationTime){ 
            //Simulate current event
            this.currentEvent = pec.nextEventPEC();
            //Updates the current Time
            this.currentTime = this.currentEvent.getEventTime();
            this.currentEvent.handleEvent();
            //Add new events to pec
            List<IEvent> newEvents = this.currentEvent.getNewEvents();
            for (IEvent event : newEvents) {
                pec.addEventPEC(event);
            }
            //Checks if the Events are valid. If they arent, dont add them to the PEC
            if(this.currentEvent.valid() && this.currentEvent.getEventTime() <= this.simulationTime){
                // Only adds to PEC events within simulationTime, and valid events
                pec.addEventPEC(this.currentEvent);
            }
        }
    }

    @Override
    public void addToPEC(IEvent event){
        pec.addEventPEC(event);
    }

}