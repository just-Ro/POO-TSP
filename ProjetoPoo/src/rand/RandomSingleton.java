package rand;

public class RandomSingleton {
    private static CustomRandom instance;
    
    public static CustomRandom getInstance(){

        if (instance == null)
            instance = new CustomRandom();

        return instance;
    }

}
