import lab2.BasicFunctions;
import lab2.TaskMath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicFunctionsUnitTest {

    public static final double ALLOWED_ACCURACY = 0.01;

    private static Stream<Arguments> cosArgumentsProvider(){
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(Math.PI/2, 0),
                Arguments.of(Math.PI, -1),
                Arguments.of(Math.PI/6, Math.sqrt(3)/2),
                Arguments.of(Math.PI/4, Math.sqrt(2)/2),
                Arguments.of(Math.PI/3, 0.5),
                Arguments.of((2*Math.PI)/3, -0.5),
                Arguments.of((3*Math.PI)/4, -1* Math.sqrt(2)/2),
                Arguments.of((5*Math.PI)/6, -1 * Math.sqrt(3)/2)
        );
    }

    private static Stream<Arguments> logArgumentsProvider(){
        return Stream.of(
                Arguments.of(Math.exp(3), 3),
                Arguments.of(Math.exp(5), 5),
                Arguments.of(Math.exp(8), 8),
                Arguments.of(1, 0),
                Arguments.of(Math.exp(10), 10),
                Arguments.of(Math.exp(0.1), 0.1),
                Arguments.of(0, Double.NaN),
                Arguments.of(-5, Double.NaN),
                Arguments.of(-1, Double.NaN),
                Arguments.of(-0.5, Double.NaN)
        );
    }

    @ParameterizedTest
    @MethodSource("cosArgumentsProvider")
    void testPositiveArgsCos(double x, double expected){
        assertEquals(expected, BasicFunctions.cos(x), ALLOWED_ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("cosArgumentsProvider")
    void testNegativeArgsCos(double x, double expected) {
        assertEquals(expected, BasicFunctions.cos(-x), ALLOWED_ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("logArgumentsProvider")
    void testLogarithm(double x, double expected){
        assertEquals(expected, BasicFunctions.ln(x), ALLOWED_ACCURACY);
    }

    @Test
    void testBorderValuesCos(){
        TaskMath math = new TaskMath();
        assertEquals(Double.NaN, math.cos(Double.NaN));
        assertEquals(Double.NaN, math.cos(Double.NEGATIVE_INFINITY));
        assertEquals(Double.NaN, math.cos(Double.POSITIVE_INFINITY));
    }

}
