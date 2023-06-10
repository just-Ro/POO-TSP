package simulation;

public interface Event {

    public double getEventTime();
    public void handleEvent();
    public void updateSimulationState();
}
