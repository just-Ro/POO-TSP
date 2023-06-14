package simulation;

import rand.CustomRandom;
import rand.RandomSingleton;

public abstract class AEvent implements IEvent{

    protected double eventTime;

    public AEvent(double eventTime){
        this.eventTime = eventTime;
    }

     @Override
    public double getEventTime(){
        return eventTime;
    }

    protected static double expRandom(double m) {
        CustomRandom random = RandomSingleton.getInstance();
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }

    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public void handleEvent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEvent'");
    }
}
