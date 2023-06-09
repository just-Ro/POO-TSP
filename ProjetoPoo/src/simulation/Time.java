package simulation;

public class Time implements Event{

    private double eventTime;

    public Time(double time){
        this.eventTime = time;
        handleEvent();
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
