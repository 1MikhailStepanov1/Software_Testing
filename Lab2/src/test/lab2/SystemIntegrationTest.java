import lab2.MathSystem;
import lab2.TaskMath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemIntegrationTest {

    public static final double STEP = 0.001;

    MathSystem system = new MathSystem(new TaskMath());

    @ParameterizedTest
    @ValueSource(doubles={-3.804, -5.292, -2.0457, -1.2789, -10.088, -11.575, -11.339, -7.245, -5.461})
    void testSpecialPoints(double x) {
        double left = system.calculateFunction(x - STEP);
        double right = system.calculateFunction(x + STEP);
        double res = system.calculateFunction(x);
        assertTrue(res > left && res > right || res < left && res < right);
    }

    static Stream<Arguments> sysValues(){
        return Stream.of(
                Arguments.of(2, 0.171661886),
                Arguments.of(133, 5.050215353),
                Arguments.of(45, 3.159547814),
                Arguments.of(-8, 0),
                Arguments.of(0.0076, 3.877646528),
                Arguments.of(-0.1274, -1761.673137367),
                Arguments.of(-0.1249, -1872.105724978),
                Arguments.of(-0.999, -8.628567278)
        );
    }

    @ParameterizedTest
    @MethodSource("sysValues")
    void generalTest(double x, double expected) {
        assertEquals(expected, system.calculateFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

}
