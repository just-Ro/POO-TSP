package rand;

/**
 * The RandomSingleton class implements the singleton pattern to provide a single instance of the CustomRandom class.
 * It ensures that only one instance of CustomRandom is created and shared across the application.
 * This class is thread-safe.
 * 
 * This class is designed to be used as a singleton, meaning that only one instance should be created throughout the application.
 * The getInstance() method is used to obtain the singleton instance of CustomRandom.
 * 
 * Example usage:
 * CustomRandom random = RandomSingleton.getInstance();
 * 
 * Note: The actual implementation of the CustomRandom class is not shown here.
 * The RandomSingleton class assumes that the CustomRandom class exists and has appropriate functionality.
 * 
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
