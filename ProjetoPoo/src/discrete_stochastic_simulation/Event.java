package discrete_stochastic_simulation;

public interface Event {
    
    public void handleEvent();
    public void updateSimulationState();
}
