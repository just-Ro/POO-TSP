package rand;

/**
 * The myMath class provides mathematical utility functions.
 * It includes methods for generating exponentially distributed random numbers.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class myMath {
    
    public static double expRandom(double m) {
        CustomRandom random = RandomSingleton.getInstance();
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }
}
