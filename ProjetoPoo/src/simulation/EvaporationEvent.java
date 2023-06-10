package simulation;

public class EvaporationEvent implements Event{

    private double eventTime;

    public EvaporationEvent(double time){
        this.eventTime = time;
        handleEvent();
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
