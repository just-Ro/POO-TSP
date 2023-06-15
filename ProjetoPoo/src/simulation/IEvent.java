package simulation;

import java.util.List;

public interface IEvent {

    public double getEventTime();
    public void handleEvent();
    public void updateSimulationState();
    public boolean valid();
    public List<IEvent> getNewEvents();
}
