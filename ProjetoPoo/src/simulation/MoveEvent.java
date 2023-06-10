package simulation;

public class MoveEvent implements IEvent{

    private double eventTime;

    public MoveEvent(double time){
        this.eventTime = time;
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }

    @Override
    public void handleEvent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEvent'");

        //Programar proximo move Event
        
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }
    
}
