package simulation;

public class Evaporation implements Event{

    private double eventTime;

    public Evaporation(double time){
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
