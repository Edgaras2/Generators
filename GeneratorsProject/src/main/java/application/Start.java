package application;

import servicesImpl.GeneratorCalculationServiceImpl;

/**
 * Application creates, calculates generators values, those values converted to bits,
 * then compared between generators and matches is calculated.
 *
 * @author Edgaras Bajorinas
 * @since 2019-12-04
 */
public class Start {
    public static void main(String... args) {
        GeneratorCalculationServiceImpl generatorHelper = new GeneratorCalculationServiceImpl();

        if (args.length == 2) {
            System.out.println(generatorHelper.generatorsCalculation(args));
        } else {
            System.out.println("Please enter two starting values");
        }
    }
}
