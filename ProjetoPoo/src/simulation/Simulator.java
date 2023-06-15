package simulation;

import java.util.List;

public class Simulator {
    
    private PEC pec;
    private double simulationTime;
    private IEvent currentEvent;
    private double currentTime;
    
    public Simulator(double finalInstant){
        this.simulationTime = finalInstant;
        this.currentTime = 0;
        this.pec = new PEC();
    }
    
    public void run(){
        while(!pec.isEmpty() && this.currentTime <= this.simulationTime){ 
            //Simulate current event
            this.currentEvent = pec.nextEventPEC();
            this.currentEvent.handleEvent();

            //Add new events to pec
            List<IEvent> newevents = this.currentEvent.getNewEvents();
            for (IEvent event : newevents) {
                pec.addEventPEC(event);
            }
            
            this.currentTime = this.currentEvent.getEventTime();
            if(this.currentEvent.valid() && this.currentEvent.getEventTime() <= this.simulationTime){
                // Only adds to PEC events within simulationTime, and valid events
                pec.addEventPEC(this.currentEvent);
            }
        }
    }

    public void addToPEC(IEvent event){
        pec.addEventPEC(event);
    }

}