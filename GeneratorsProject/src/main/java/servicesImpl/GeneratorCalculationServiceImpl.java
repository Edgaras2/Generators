package servicesImpl;

import enums.Generators;
import org.apache.commons.lang3.StringUtils;
import services.GeneratorCalculationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link GeneratorCalculationService}
 *
 * @author Edgaras Bajorinas
 * @since 2019-12-04
 */
public class GeneratorCalculationServiceImpl implements GeneratorCalculationService {

    /**
     * {@inheritDoc}
     *
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    @Override
    public int generatorsCalculation(String... generatorsNumbers) {
        List<List<Integer>> generators = createGenerators();
        calculateFirstGeneratorsValues(generators, generatorsNumbers);
        calculateGeneratorsValues(generators);
        return compareGeneratorsValuesBits(generators);
    }

    /**
     * Creates generators and adds them to the list.
     * For scalability Generators.values().length is used, when new Generator is added to the Generators enum it will automatically created.
     *
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    private List<List<Integer>> createGenerators() {
        List<List<Integer>> generators = new ArrayList<>();
        for (int i = 0; i < Generators.values().length; i++) {
            generators.add(new ArrayList<>());
        }
        return generators;
    }

    /**
     * Calculates first values and adds them to generators list.
     *
     * @param generators        list which holds data of generators
     * @param generatorsNumbers generators starting numbers
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    private void calculateFirstGeneratorsValues(List<List<Integer>> generators, String[] generatorsNumbers) {
        for (int i = 0; i < Generators.values().length; i++) {
            if (i % 2 == 0) {
                generators.get(i).add(calculateGeneratorValue(Integer.valueOf(generatorsNumbers[i]), Generators.GENERATOR_A.coefficient));
            } else {
                generators.get(i).add(calculateGeneratorValue(Integer.valueOf(generatorsNumbers[i]), Generators.GENERATOR_B.coefficient));
            }
        }
    }

    /**
     * Adds calculated value to generator list.
     *
     * @param generators list which holds data of generators
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    private void calculateGeneratorsValues(List<List<Integer>> generators) {
        for (int i = 0; i < 999999; i++) {
            for (int j = 0; j < generators.size(); j++) {
                if (j % 2 == 0) {
                    generators.get(j).add(calculateGeneratorValue(generators.get(j).get(i), Generators.GENERATOR_A.coefficient));
                } else {
                    generators.get(j).add(calculateGeneratorValue(generators.get(j).get(i), Generators.GENERATOR_B.coefficient));
                }
            }
        }
    }

    /**
     * Calculates generator value.
     *
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    private int calculateGeneratorValue(Integer generatorNumber, double coefficient) {
        double divider = 2147483647;
        return (int) Math.round(generatorNumber * coefficient % divider);
    }

    /**
     * Compares bits values between Generator A and Generator B.
     *
     * @return count of matched bit values
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    private int compareGeneratorsValuesBits(List<List<Integer>> generators) {
        int count = 0;
        for (int i = 0; i < generators.get(0).size(); i++) {
            if (getGeneratorValueBits(generators.get(0), i).equals(getGeneratorValueBits(generators.get(1), i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Converts generator values to bits and returns last 8 digits.
     *
     * @param list  holds generator values
     * @param index of number which will be converted to bits
     * @return last 8 digits of converted bits
     * @author Edgaras Bajorinas
     * @since 2019-12-04
     */
    private String getGeneratorValueBits(List<Integer> list, int index) {
        String bits = StringUtils.leftPad(Integer.toBinaryString(list.get(index)), 32, "0");
        return bits.substring(bits.length() - 8, bits.length());
    }
}
