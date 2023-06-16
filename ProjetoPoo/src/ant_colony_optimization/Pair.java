package ant_colony_optimization;
/**
 * The Pair class represents a pair of values.
 * It contains methods to update and retrieve the first and second values of the pair.
 *
 * @author João Mateus
 * @author Rodrigo Francisco
 * @author Tiago Mira
 */
public class Pair implements IPair {
    private String fvalue;
    private Path svalue;

    /**
     * Constructs a Pair object with null values.
     */
    public Pair(){
        fvalue = null;
        svalue = null;
    }

    /**
     * Constructs a Pair object with the specified values.
     * @param fvalue the value for the first element of the Pair
     * @param svalue the value for the second element of the Pair
     */
    public Pair(String fvalue, Path svalue) {
        this.fvalue = fvalue;
        this.svalue = svalue;
    }

    public void update(String fnew, Path snew){
        this.fvalue = fnew;
        this.svalue = snew;
    }

    public void updateFirst(String fnew){
        this.fvalue = fnew;
    }

    public void updateSecond(Path snew){
        this.svalue = snew;
    }

    public String getFirst(){
        return fvalue;
    }

    public Path getSecond(){
        return svalue;
    }

    public int getWeight(){
        return svalue.pathWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.fvalue).append(" ").append(this.svalue);
        return sb.toString();
    }

}