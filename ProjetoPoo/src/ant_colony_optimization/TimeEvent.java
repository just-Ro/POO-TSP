package ant_colony_optimization;

import simulation.AEvent;

public class TimeEvent extends AEvent{

    private int counter = 0;
    private double finalInstant;

    public TimeEvent(double time, double finalInstant){
        super(time);
        this.finalInstant=finalInstant;
        handleEvent();
    }
    
    @Override
    public void handleEvent() {
        System.out.println("oi tempo: " + this.eventTime);
        this.counter++;
        this.eventTime = (counter*finalInstant)/20;
    }
    
}
