package simulation;

import java.util.ArrayList;
import java.util.List;

import rand.CustomRandom;
import rand.RandomSingleton;

public abstract class AEvent implements IEvent{

    protected double eventTime;
    protected List<IEvent> newevents = new ArrayList<>();

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

    //Returns a list with the newevents and resets that list
    @Override
    public List<IEvent> getNewEvents(){
        List<IEvent> eventsCopy = new ArrayList<>(newevents);
        newevents.clear();
        return eventsCopy;
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
