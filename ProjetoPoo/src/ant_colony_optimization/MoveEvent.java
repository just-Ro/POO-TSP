package ant_colony_optimization;

import java.util.Random;
import simulation.IEvent;

public class MoveEvent implements IEvent{

    private double eventTime;
    private Ant formiga;
    private double delta;
    

    public MoveEvent(double time, Ant formiga, double delta){
        this.formiga = formiga;
        this.delta = delta;
        formiga.nextNode();
        this.eventTime = time + expRandom(delta*formiga.edgeWeight());
    }
    
    @Override
    public double getEventTime(){
        return eventTime;
    }


    @Override
    public void handleEvent() {
        formiga.travel();
        formiga.nextNode();
        //Programar proximo move Event
        this.eventTime += expRandom(delta*formiga.edgeWeight());
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }


    private static double expRandom(double m) {
        Random random = RandomSingleton.getInstance();
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }
}
