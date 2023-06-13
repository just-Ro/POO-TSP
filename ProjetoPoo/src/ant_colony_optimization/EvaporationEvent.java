package ant_colony_optimization;

import java.util.Random;
import simulation.IEvent;

//Apos n movimentos, por cada edge do ciclo, criar um evento de evaporacao
//Simulacao a partir de n movimentos: if ph > 0 -> dar schedule da proxima evaporacao

public class EvaporationEvent implements IEvent{

    private double eventTime;
    private double eta, rho;
    private int source, dest;
    private PheroGraph pGraph;

    public EvaporationEvent(double time, double eta, double rho, int source, int dest, PheroGraph pGraph){
        this.eventTime = time;
        this.eta = eta;
        this.rho = rho;
        this.dest = dest;
        this.source = source;
        this.pGraph = pGraph;
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }

    @Override
    public void handleEvent() {
        
        this.pGraph.updateEdge(source, dest, -this.rho);
        this.eventTime += expRandom(eta);

    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }

    public static double expRandom(double m) {
        Random random = RandomSingleton.getInstance();
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }

}
