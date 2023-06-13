package ant_colony_optimization;

import simulation.IEvent;

public class TimeEvent implements IEvent{

    private double eventTime;
    private int counter = 0;
    private double finalInstant;

    public TimeEvent(double time, double finalInstant){
        this.eventTime = time;
        this.finalInstant=finalInstant;
        handleEvent();
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }
    
    @Override
    public void handleEvent() {
        this.counter++;
        this.eventTime += (counter*finalInstant)/20;
        System.out.println("oi, passou 1/20 do time :), eventualmente dar print do mpt ciclo hamilton");
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }
    
}
