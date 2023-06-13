package ant_colony_optimization;

import java.util.Random;

import simulation.IEvent;

//Inicializacao - 1 evento na PEC por cada formiga na colonia
//Apos n movimentos, por cada edge do ciclo, criar um evento de evaporacao
//Simulacao a partir de n movimentos: if ph > 0 -> dar schedule da proxima evaporacao
//Eventos: Movimento, Evaporacao, /20 do tempo

public class EvaporationEvent implements IEvent{

    private double eventTime;
    private double rho;

    public EvaporationEvent(double time, double rho){
        this.eventTime = time;
        this.rho = rho; 
        handleEvent();
    }

    @Override
    public double getEventTime(){
        return eventTime;
    }

    @Override
    public void handleEvent() {
        this.eventTime += expRandom(rho);
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }

    static Random random = new Random();

    public static double expRandom(double m) {
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }

}
