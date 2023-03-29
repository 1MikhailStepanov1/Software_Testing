package firstTask;

import lab1.firstTask.Sec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Sec test")
public class SecTest {

    private Sec sec;

    @BeforeEach
    void setUp(){
        this.sec = new Sec();
    }

    @ParameterizedTest(name = "Sec general test")
    @CsvFileSource(resources = "/sec_values.csv")
    void secValueTest(double expected, double input){
        final double angle = sec.getAngleValue(input);
        double current = sec.secant(angle);
        double accuracy = 1e-6;
        System.out.printf("input = %9f | current = %9f | expected = %9f\n", input, expected, current);
        assertEquals(expected, current, accuracy);
    }

    @ParameterizedTest(name = "Sec exception test")
    @ValueSource(doubles = {6666666666666.66, 237954444, -124124124})
    void secExceptionTest(double input){
        assertThrows(ArithmeticException.class, () -> {
            sec.secant(input);
        });
    }

}
