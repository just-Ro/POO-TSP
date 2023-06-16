package ant_colony_optimization;

import simulation.AEvent;
import static rand.myMath.expRandom;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class MoveEvent extends AEvent implements IMoveEvent{

    private Ant formiga;
    private double delta;
    

    public MoveEvent(double time, Ant formiga, double delta){
        super(time);
        this.formiga = formiga;
        this.delta = delta;
        formiga.nextNode();
        this.eventTime += expRandom(delta*formiga.edgeWeight());
    }

    @Override
    public void handleEvent() {
        //System.out.println("oi move: " + this.eventTime);
        //System.out.println(formiga);
        //System.out.println("moveu!" + eventTime);
        formiga.travel(eventTime, newevents);
        //Choose next node
        formiga.nextNode();
        //Program next Move Event
        this.eventTime += expRandom(delta*formiga.edgeWeight());
        //System.out.println("prox mov: " + this.eventTime);
    }

}
