import lab2.TaskMath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogarithmicFunctionIntegrationTest {

    TaskMath math = new TaskMath();

    static Stream<Arguments> logArgs(){
        return Stream.of(
                Arguments.of(81, 3, 4),
                Arguments.of(256, 4, 4),
                Arguments.of(5, -4, Double.NaN),
                Arguments.of(8, 64, 0.5),
                Arguments.of(0, 7, Double.NaN),
                Arguments.of(-5, -2, Double.NaN)
        );
    }

    @ParameterizedTest
    @MethodSource("logArgs")
    void testLogArgs(double x, int base, double expected){
        assertEquals(expected, math.log(x, base), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }
}
