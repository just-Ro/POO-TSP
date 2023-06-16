package ant_colony_optimization;

import java.util.TreeSet;

import simulation.AEvent;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class TimeEvent extends AEvent implements ITimeEvent{

    private int counter = 1;
    private double finalInstant;
    private TreeSet<Pair> scoreBoard;

    public TimeEvent(double time, double finalInstant, TreeSet<Pair> scoreBoard){
        super(time);
        this.finalInstant=finalInstant;
        this.scoreBoard=scoreBoard;
        handleEvent();
    }
    
    @Override
    public void handleEvent() {
        System.out.println("oi tempo: " + this.eventTime);
        if(!scoreBoard.isEmpty()){
            if(this.eventTime!=finalInstant){
                System.out.println(scoreBoard.first());
            }else{
                for(Pair pair : scoreBoard){
                    System.out.println(pair);
                }
            }
        }else{
            System.out.println("{}");
        }

        this.counter++;
        this.eventTime = (counter*finalInstant)/20;
        //System.out.println("prox tempo: " + this.eventTime);
    }
    
}
