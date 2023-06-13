package ant_colony_optimization;

import java.util.Random;

public class RandomSingleton {
    private static final Random instance = new Random();

    public static Random getInstance(){
        return instance;
    }

}
