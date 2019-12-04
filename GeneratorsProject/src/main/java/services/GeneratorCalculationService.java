package services;

/**
 * Service for generator calculation.
 *
 * @author Edgaras Bajorinas
 * @since 2019-12-04
 */
public interface GeneratorCalculationService {

    /**
     * Creates generators and calculates their value.
     * Converts generator values to bits and compares between Generator A and Generator B.
     *
     * @param generatorsNumbers generators starting numbers
     * @return count of how many bits were a match between Generator A and Generator B
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    int generatorsCalculation(String... generatorsNumbers);
}
