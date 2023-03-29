import lab2.TaskMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TaskMathUnitTest {

    TaskMath math = spy(TaskMath.class);

    @Test
    void testSin(){
        double x = 0;
        when(math.cos(x)).thenReturn(1.0);
        assertEquals(0, math.sin(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);

        x = Math.PI/2;
        when(math.cos(x)).thenReturn(0.0);
        assertEquals(1, math.sin(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

    @Test
    void testTan(){
        double x = 15;
        when(math.cos(x)).thenReturn(0.96592582628);
        when(math.sin(x)).thenReturn(0.2588190451);
        assertEquals(0.26794919243, math.tan(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

    @Test
    void testCotan(){
        double x = 20;
        when(math.sin(x)).thenReturn(0.34202014332);
        when(math.cos(x)).thenReturn(0.93969262078);
        assertEquals(2.74747741945, math.cotan(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

    @Test
    void testSec(){
        double x = -5;
        when(math.cos(x)).thenReturn(0.99619469809);
        assertEquals(1.00381983754, math.sec(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

    @Test
    void testCosec(){
        double x = -17;
        when(math.sin(x)).thenReturn(-0.29237170472);
        assertEquals(-3.42030361983, math.cosec(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

    @Test
    void testLog(){
        int base = 4;
        double x = 256;

        when(math.ln(base)).thenReturn(1.38629436112);
        when(math.ln(x)).thenReturn(5.54517744448);
        assertEquals(4, math.log(x, base), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }
}
