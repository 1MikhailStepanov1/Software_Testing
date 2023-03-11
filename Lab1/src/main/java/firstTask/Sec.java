package firstTask;

public class Sec {

    private double cos(double rads) throws ArithmeticException {
        double ans = 1;
        double cur = 1;
        double prev = 0;
        final double accuracy = 1e-6;

        for (int i = 1; Math.abs(cur - prev) > accuracy && i < 1000 ; i++) {
            prev = cur;
            cur *= (-rads * rads);
            cur /= ((2 * i) * (2 * i - 1));
            ans += cur;
        }

        if (ans < -1) return -1;
        if (ans > 1) return 1;
        if (Double.isInfinite(ans) || Double.isNaN(ans)) {
            throw new ArithmeticException("Too big value.");
        }
        return ans;
    }

    public double getAngleValue(double input){
        return input / 180 * Math.PI;
    }

    public double secant(double input){
        double result;
        double cos = cos(input);
        result = 1 / cos;
        return result;
    }
}
