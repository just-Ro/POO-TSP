package simulation;

import java.util.*;

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
        while(this.currentTime < this.simulationTime){ 
            //Simulate current event
            this.currentEvent = pec.nextEventPEC();
            this.currentEvent.handleEvent();
            pec.addEventPEC(this.currentEvent);
        }
    }

    public void addToPEC(List<IEvent> eventList){
        for (IEvent ev : eventList) {
            pec.addEventPEC(ev);
        }
    }

}