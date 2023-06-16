package simulation;

import java.util.List;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Simulator implements ISimulator{
    
    private IPEC pec;
    private double simulationTime;
    private IEvent currentEvent;
    private double currentTime;
    
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
            List<IEvent> newevents = this.currentEvent.getNewEvents();
            for (IEvent event : newevents) {
                pec.addEventPEC(event);
            }
            //Checks if the Events are valid. If they arent, dont add them to the PEC
            if(this.currentEvent.valid() && this.currentEvent.getEventTime() <= this.simulationTime){
                // Only adds to PEC events within simulationTime, and valid events
                pec.addEventPEC(this.currentEvent);
            }else if (!this.currentEvent.valid()){
                //System.out.println("EVENTO ELIMINADO");
            }
        }
    }

    @Override
    public void addToPEC(IEvent event){
        pec.addEventPEC(event);
    }

}