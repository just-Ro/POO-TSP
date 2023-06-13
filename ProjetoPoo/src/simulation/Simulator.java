package simulation;

import java.util.List;

public class Simulator {
    
    private PEC pec;
    private double simulationTime;
    private IEvent currentEvent;
    private double currentTime;

    // tire e poe eventos na pec
    // sabe o que são eventos
    // sabe o que é a pec
    // 
    
    public Simulator(double finalInstant){
        this.simulationTime = finalInstant;
        this.currentTime = 0;
        this.pec = new PEC();
    }
    
    public void run(){
        while(!pec.isEmpty() && this.currentTime < this.simulationTime){ 
            //Simulate current event
            this.currentEvent = pec.nextEventPEC();
            this.currentEvent.handleEvent();
            //this.currentEvent.getNewEvents(ArrayList<>);
            //for(pec.add
            this.currentTime = this.currentEvent.getEventTime();
            if(!this.currentEvent.valid() && this.currentEvent.getEventTime() < this.simulationTime){
                // Only adds to PEC events within simulationTime, and valid events
                pec.addEventPEC(this.currentEvent);
            }
        }
    }

    public void addToPEC(IEvent event){
        pec.addEventPEC(event);
    }

}