package rand;

import java.util.Random;
import java.util.List;

/**
 * The CustomRandom class extends the Random class and provides additional methods for generating weighted random values.
 * It allows generating random values based on a list of probabilities.
 * 
 * The class provides methods for generating random integers and computing cumulative probabilities.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class CustomRandom extends Random implements ICustomRandom{

    /**
     * Constructs a new CustomRandom object.
     * It initializes the random number generator.
     */
    public CustomRandom(){
        super();
    }

    @Override
    public int weightedRandom(List<Double> chances) {
        double[] cProbs = computeCumulativeProbabilities(chances);

        // Generate a random number between 0 and the total sum of probabilities
        double randomValue = nextDouble() * cProbs[cProbs.length - 1];

        // Find the index where the random number falls within the range
        int selectedIndex = 0;
        while (selectedIndex < cProbs.length && randomValue > cProbs[selectedIndex]) {
            selectedIndex++;
        }

        return selectedIndex;
    }

    @Override
    public double[] computeCumulativeProbabilities(List<Double> chances) {
        double[] cProbs = new double[chances.size()];
        cProbs[0] = chances.get(0);

        // Compute the cumulative probabilities
        for (int i = 1; i < chances.size(); i++) {
            cProbs[i] = cProbs[i - 1] + chances.get(i);
        }

        return cProbs;
    }
}
