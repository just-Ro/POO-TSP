package simulation;

public class TimeEvent implements IEvent{

    private double eventTime;

    public TimeEvent(double time){
        this.eventTime = time;
        
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }
    
    @Override
    public void handleEvent() {
        System.out.println("oi, passou 1/20 do time :)");
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEvent'");
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }
    
}
