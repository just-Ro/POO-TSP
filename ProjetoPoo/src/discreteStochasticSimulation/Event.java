package discreteStochasticSimulation;

public interface Event {
    
    public void handleEvent();
    public void updateSimulationState();
}
