import lab2.TaskMath;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometricFunctionIntegrationTest {

    TaskMath math = new TaskMath();

    @Nested
    class Sinus{

        static Stream<Arguments> sinArgs(){
            return Stream.of(
                    Arguments.of(0, 0),
                    Arguments.of(Math.PI/6, 0.5),
                    Arguments.of(Math.PI/4, Math.sqrt(2)/2),
                    Arguments.of(Math.PI/3, Math.sqrt(3)/2),
                    Arguments.of(Math.PI/2, 1.0),
                    Arguments.of(-1*Math.PI/6, -0.5),
                    Arguments.of(-1*Math.PI/4, -1*Math.sqrt(2)/2),
                    Arguments.of(-1*Math.PI/3, -1*Math.sqrt(3)/2),
                    Arguments.of(-1*Math.PI/2, -1.0),
                    Arguments.of(Math.PI, 0.0)
            );
        }

        @ParameterizedTest
        @MethodSource("sinArgs")
        void testPositiveArgs(double x, double expected){
            assertEquals(expected, math.sin(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @ParameterizedTest
        @MethodSource("sinArgs")
        void testNegativeArgs(double x, double expected){
            assertEquals(-1*expected, math.sin(-1*x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }

    @Nested
    class Tangent{

        static Stream<Arguments> tanArgs(){
            return Stream.of(
                    Arguments.of(0.0, 0.0),
                    Arguments.of(Math.PI/6, 1/Math.sqrt(3)),
                    Arguments.of(Math.PI/4, 1.0),
                    Arguments.of(Math.PI/3, Math.sqrt(3)),
                    Arguments.of(-1*Math.PI/6, -1/Math.sqrt(3)),
                    Arguments.of(-1*Math.PI/4, -1.0),
                    Arguments.of(-1*Math.PI/3, -1*Math.sqrt(3)),
                    Arguments.of(Math.PI, 0.0)
            );
        }

        @ParameterizedTest
        @MethodSource("tanArgs")
        void testPositiveArgs(double x, double expected){
            assertEquals(expected, math.tan(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @ParameterizedTest
        @MethodSource("tanArgs")
        void testNegativeArgs(double x, double expected){
            assertEquals(-1*expected, math.tan(-1*x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }

    @Nested
    class Cotangent{

        static Stream<Arguments> cotanArgs(){
            return Stream.of(
                    Arguments.of(Math.PI/2, 0.0),
                    Arguments.of(Math.PI/6, Math.sqrt(3)),
                    Arguments.of(Math.PI/4, 1.0),
                    Arguments.of(Math.PI/3, 1/Math.sqrt(3)),
                    Arguments.of(-1*Math.PI/6, -1*Math.sqrt(3)),
                    Arguments.of(-1*Math.PI/4, -1.0),
                    Arguments.of(-1*Math.PI/3, -1/Math.sqrt(3)),
                    Arguments.of(-1*Math.PI/2, 0.0)
            );
        }

        @ParameterizedTest
        @MethodSource("cotanArgs")
        void testPositiveArgs(double x, double expected){
            assertEquals(expected, math.cotan(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @ParameterizedTest
        @MethodSource("cotanArgs")
        void testNegativeArgs(double x, double expected){
            assertEquals(-1*expected, math.cotan(-1*x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }

    @Nested
    class Secant{
        static Stream<Arguments> secArgs(){
            return Stream.of(
                    Arguments.of(0.0, 1.0),
                    Arguments.of(Math.PI/6, 2*Math.sqrt(3)/3),
                    Arguments.of(Math.PI/4, Math.sqrt(2)),
                    Arguments.of(Math.PI/3, 2),
                    Arguments.of(-1*Math.PI/6, 1*2*Math.sqrt(3)/3),
                    Arguments.of(-1*Math.PI/4, 1*Math.sqrt(2)),
                    Arguments.of(-1*Math.PI/3, 2.0),
                    Arguments.of(Math.PI, -1.0)
            );
        }

        @ParameterizedTest
        @MethodSource("secArgs")
        void testPositiveArgs(double x, double expected){
            assertEquals(expected, math.sec(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @ParameterizedTest
        @MethodSource("secArgs")
        void testNegativeArgs(double x, double expected){
            assertEquals(expected, math.sec(-1*x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }

    @Nested
    class Cosecant {
        static Stream<Arguments> cosecArgs(){
            return Stream.of(
                    Arguments.of(Math.PI/2, 1.0),
                    Arguments.of(Math.PI/6, 2),
                    Arguments.of(Math.PI/4, Math.sqrt(2)),
                    Arguments.of(Math.PI/3, 2*Math.sqrt(3)/3),
                    Arguments.of(-1*Math.PI/6, -2.0),
                    Arguments.of(-1*Math.PI/4, -1*Math.sqrt(2)),
                    Arguments.of(-1*Math.PI/3, -2*Math.sqrt(3)/3)
            );
        }

        @ParameterizedTest
        @MethodSource("cosecArgs")
        void testPositiveArgs(double x, double expected){
            assertEquals(expected, math.cosec(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @ParameterizedTest
        @MethodSource("cosecArgs")
        void testNegativeArgs(double x, double expected){
            assertEquals(-1*expected, math.cosec(-1*x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }
}
