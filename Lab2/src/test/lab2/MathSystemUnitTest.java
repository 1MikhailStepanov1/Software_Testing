import lab2.MathSystem;
import lab2.TaskMath;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MathSystemUnitTest {

    @Nested
    class TestLogarithmicFunction {
        TaskMath math = spy(TaskMath.class);
        MathSystem system = new MathSystem(math);

        @Test
        void testEquation() {
            double x = 3;
            when(math.log(x, 10)).thenReturn(0.477121255);
            when(math.log(x, 2)).thenReturn(1.5849625007);
            when(math.log(x, 5)).thenReturn(0.6826061944);
            when(math.log(x, 3)).thenReturn(1.0);
            assertEquals(0.355394842, system.logarithmicFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @Test
        void testValueCloseToZero(){
            double x = 0.01;
            when(math.log(x, 10)).thenReturn(-2.0);
            when(math.log(x, 2)).thenReturn(-6.64385619);
            when(math.log(x, 5)).thenReturn(-2.861353116);
            when(math.log(x, 3)).thenReturn(-4.191806549);
            assertEquals(3.423224380, system.logarithmicFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @Test
        void testOutOfRangeValue(){
            double x = -1;
            when(math.log(x, 10)).thenReturn(0.0);
            when(math.log(x, 2)).thenReturn(0.0);
            when(math.log(x, 5)).thenReturn(0.0);
            when(math.log(x, 3)).thenReturn(0.0);
            assertEquals(Double.NaN, system.logarithmicFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }

    @Nested
    class TestTrigonometricFunction{
        TaskMath math = mock(TaskMath.class);
        MathSystem system = new MathSystem(math);

        @Test
        void testEquation(){
            double x = -2;
            when(math.cos(x)).thenReturn(0.99939082701);
            when(math.sin(x)).thenReturn(-0.0348994967);
            when(math.tan(x)).thenReturn(-0.03492076949);
            when(math.cotan(x)).thenReturn(-28.6362532829156);
            when(math.sec(x)).thenReturn(1.00060954431);
            when(math.cosec(x)).thenReturn(-28.6537083499);

            assertEquals(-91100.38349292395, system.trigonometricFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @Test
        void testOutOfRangeValue(){
            double x = Math.PI/3;
            when(math.cos(x)).thenReturn(0.5);
            when(math.sin(x)).thenReturn(Math.sqrt(3)/2);
            when(math.tan(x)).thenReturn(Math.sqrt(3));
            when(math.cotan(x)).thenReturn(1/Math.sqrt(3));
            when(math.sec(x)).thenReturn(2.0);
            when(math.cosec(x)).thenReturn(2/Math.sqrt(3));
            assertEquals(Double.NaN, system.calculateFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }

        @Test
        void testWithTableValue(){
            double x = -Math.PI/6;
            when(math.cos(x)).thenReturn(Math.sqrt(3)/2);
            when(math.sin(x)).thenReturn(-0.5);
            when(math.tan(x)).thenReturn(-1/Math.sqrt(3));
            when(math.cotan(x)).thenReturn(-1 * Math.sqrt(3));
            when(math.sec(x)).thenReturn(2/Math.sqrt(3));
            when(math.cosec(x)).thenReturn(-2.0);

            assertEquals(-24.787905696, system.calculateFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
        }
    }

    @Nested
    class TestWholeFunction{
        MathSystem system = spy(new MathSystem(new TaskMath()));

        @Test
        void testNegativeArg(){
            double x = -2;
            double result = -91100.38349292395;
            doReturn(result).when(system).trigonometricFunction(x);
            doThrow(RuntimeException.class).when(system).logarithmicFunction(any(Double.class));
            assertEquals(result, system.calculateFunction(x));
        }

        @Test
        void testSystemWithPositiveArg() {
            double x = 3;
            double result = 0.355394842;
            doReturn(result).when(system).logarithmicFunction(x);
            doThrow(RuntimeException.class).when(system).trigonometricFunction(any(Double.class));
            assertEquals(result, system.calculateFunction(x));
        }

        @Test
        void testSystemWithZero() {
            double x = 0;
            double result = Double.NaN;
            doReturn(result).when(system).trigonometricFunction(x);
            doThrow(RuntimeException.class).when(system).logarithmicFunction(any(Double.class));
            assertEquals(result, system.calculateFunction(x));
        }
    }

}
