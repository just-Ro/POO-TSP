package rand;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class RandomSingleton {
    private static CustomRandom instance;
    
    public static CustomRandom getInstance(){

        if (instance == null)
            instance = new CustomRandom();

        return instance;
    }

}
