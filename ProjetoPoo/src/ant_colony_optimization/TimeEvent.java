package ant_colony_optimization;

import java.util.TreeSet;
import java.util.Iterator;
import simulation.AEvent;

/**
 * The `TimeEvent` class represents an event that occurs at specific time intervals during the execution of the ant colony optimization algorithm.
 * It is responsible for printing the best paths found in the score board at regular intervals of time.
 * The time intervals are determined by the final instant and the number of intervals.
 * The score board contains the best paths discovered by the algorithm.
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * // Create a TreeSet to hold the best paths
 * TreeSet<Pair> scoreBoard = new TreeSet<>();
 * 
 * // Create a TimeEvent with the desired parameters
 * TimeEvent timeEvent = new TimeEvent(0.0, finalInstant, scoreBoard);
 * }</pre>
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class TimeEvent extends AEvent implements ITimeEvent{

    private int counter = 1;
    private double finalInstant;
    private TreeSet<Pair> scoreBoard;
    private Colony col;

    public TimeEvent(double time, double finalInstant, TreeSet<Pair> scoreBoard, Colony col){
        super(time);
        this.finalInstant=finalInstant;
        this.scoreBoard=scoreBoard;
        this.col = col;
        //handleEvent();
    }
    
    @Override
    public void handleEvent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Observation " + this.counter + ":");
        String topic1 = sb.toString();

        sb = new StringBuilder();
        sb.append(String.format("Present instant:              %.2f\n", this.eventTime));
        sb.append(String.format("Number of move events:        %d\n", col.getMevents()));
        sb.append(String.format("Number of evaporation events: %d\n", col.getEevents()));

        if(scoreBoard.isEmpty()){
            sb.append("Top candidate cycles:         \n");
            sb.append("Best Hamiltonian cycle:       \n");
        }else{
            if(scoreBoard.size()==1){
                sb.append("Top candidate cycles:         ").append(scoreBoard.first().getSecond().toString()).append("\n");
                sb.append("Best Hamiltonian cycle:       ").append(scoreBoard.first().getSecond().toString()).append("\n");
            }else{
                Iterator<Pair> scores = scoreBoard.iterator();
                String best = new String();
                for(int i=0; scores.hasNext(); i++){
                    if(i==0){
                        best = scores.next().getSecond().toString();
                    }else if(i==1){
                        sb.append("Top candidate cycles:         ").append(scores.next().getSecond().toString()).append("\n");
                    }else{
                        sb.append("                              ").append(scores.next().getSecond().toString()).append("\n");
                    }
                }
                sb.append("Best Hamiltonian cycle:       ").append(best).append("\n");
            }
            
            if(this.eventTime==finalInstant){
                //do final instant stuff
            }
        }
        String topic2 = sb.toString();

        sb = new StringBuilder();
        sb.append(indentString(topic1, 0));
        sb.append(indentString(topic2, 10));
        System.out.println(sb.toString());

        this.counter++;
        this.eventTime = (counter*finalInstant)/20;
        //System.out.println("prox tempo: " + this.eventTime);
    }
    
    public String indentString(String string, int spaces){
        StringBuilder sb = new StringBuilder();
        String[] lines = string.split("\\r?\\n");

        for (String line : lines) {
            sb.append(" ".repeat(spaces));  // Add the desired number of spaces
            sb.append(line).append("\n");   // Append the original line with a newline character
        }

        return sb.toString();
    }
}
