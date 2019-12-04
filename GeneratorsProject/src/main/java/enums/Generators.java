package enums;

/**
 * Enum class to define generators with coefficient which is later used in their value calculation.
 *
 * @author Edgaras Bajorinas
 * @since 2019-12-04
 */
public enum Generators {

    GENERATOR_A(16807),
    GENERATOR_B(48271);

    public final double coefficient;

    Generators(double coefficient) {
        this.coefficient = coefficient;
    }
}
