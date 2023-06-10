package simulation;

public class MoveEvent implements Event{

    private double eventTime;

        public MoveEvent(double time){
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
