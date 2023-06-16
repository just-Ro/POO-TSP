package ant_colony_optimization;

import simulation.AEvent;
import static rand.myMath.expRandom;

/**
 * The MoveEvent class represents an event where an ant moves to the next node.
 * It implements the IMoveEvent interface.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class MoveEvent extends AEvent implements IMoveEvent{

    private IAnt formiga;
    private double delta;
    

    public MoveEvent(double time, IAnt formiga, double delta){
        super(time);
        this.formiga = formiga;
        this.delta = delta;
        formiga.nextNode();
        this.eventTime += expRandom(delta*formiga.edgeWeight());
    }

    @Override
    public void handleEvent() {
        //Travel
        formiga.travel(eventTime, this.newEvents);
        
        //Choose next node
        formiga.nextNode();

        //Program next Move Event
        this.eventTime += expRandom(delta*formiga.edgeWeight());
    }

}
