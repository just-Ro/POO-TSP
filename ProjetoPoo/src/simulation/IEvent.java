package simulation;


public interface IEvent {

    public double getEventTime();
    public void handleEvent();
    public void updateSimulationState();
    public boolean valid();
}
