package ant_colony_optimization;
/**
 * @author João Mateus 
 * @author Rodrigo Francisco
 * @author Tiago Mira
 */
public class Pair {
    private String fvalue;
    private Path svalue;

    public Pair(){
        fvalue = null;
        svalue = null;
    }

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