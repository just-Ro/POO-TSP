package simulation;

public class EvaporationEvent implements IEvent{

    private double eventTime;
    public String eventType = "Evaporation";

    public EvaporationEvent(double time){
        this.eventTime = time;
        handleEvent();
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }

    @Override
    public void handleEvent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEvent'");
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }


}
