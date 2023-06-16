package simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
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

    @Override
    public List<IEvent> getNewEvents(){
        //Copies the list, clears the original one, and returns the copy
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
