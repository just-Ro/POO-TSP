package rand;

import java.util.Random;
import java.util.List;

public class CustomRandom extends Random{
    public CustomRandom(){
        super();
    }

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
