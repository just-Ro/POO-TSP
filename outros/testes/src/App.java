import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        SortedSet<Integer> setA = new TreeSet<>();
        setA.add(1);
        setA.add(2);

        SortedSet<Integer> setB = new TreeSet<>();
        setB.add(2);
        setB.add(1);
        
        
        System.out.println(setA.equals(setB));
    }
}
