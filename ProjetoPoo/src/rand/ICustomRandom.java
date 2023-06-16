package rand;

import java.util.List;

/**
 * The ICustomRandom interface defines the contract for generating weighted random values.
 * It provides methods for generating random integers based on a list of probabilities.
 * 
 * Implementing classes should override these methods to provide custom behavior for generating random values.
 */
public interface ICustomRandom {

    /**
     * Generates a weighted random integer based on the given list of chances.
     *
     * @param chances the list of probabilities or chances
     * @return the index of the selected element
     */
    int weightedRandom(List<Double> chances);

    /**
     * Computes the cumulative probabilities based on the given list of chances.
     *
     * @param chances the list of probabilities or chances
     * @return an array of cumulative probabilities
     */
    double[] computeCumulativeProbabilities(List<Double> chances);

}