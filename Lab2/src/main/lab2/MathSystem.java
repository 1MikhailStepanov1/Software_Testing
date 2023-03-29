package lab2;

public class MathSystem {

    private final TaskMath math;

    public MathSystem(TaskMath math) {
        this.math = math;
    }

    public double logarithmicFunction(double x) {
        return (((Math.pow((math.log(x,10) / math.log(x,10)), 2) / (math.log(x,2) / math.log(x,3))) + math.ln(x)) * (math.log(x, 5) - math.log(x,10)));
    }

    public double trigonometricFunction(double x) {
        return (((((((((((math.cotan(x) - math.cosec(x)) * math.tan(x)) - math.cosec(x)) - math.cotan(x)) - math.sin(x))
                + math.sec(x)) - (math.cosec(x) + math.cos(x))) * (math.sin(x) / (math.cosec(x) - (math.sec(x)
                / Math.pow(math.cosec(x), 3))))) - math.tan(x)) * (Math.pow(math.cotan(x), 2)
                * (((math.cosec(x) + (math.cotan(x) - math.tan(x))) - (math.cosec(x)
                - ((math.sec(x) / math.tan(x)) * math.tan(x)))) + ((math.cotan(x)
                / (((math.cosec(x) + math.sec(x)) / math.cotan(x)) / (math.cos(x) / math.sin(x)))) / math.tan(x)))))
                * (math.cotan(x) / (((math.cos(x) + (math.tan(x) + ((math.cotan(x) / math.cos(x)) / math.cotan(x))))
                * math.cosec(x)) - (Math.pow(math.cotan(x), 2)
                + ((Math.pow(math.tan(x), 3) - math.cos(x))
                + ((math.cosec(x) - math.cosec(x)) + (math.cos(x) + math.tan(x))))))));
    }

    public double calculateFunction(double x){
        if (x <= 0){
            return trigonometricFunction(x);
        } else return logarithmicFunction(x);
    }

}
