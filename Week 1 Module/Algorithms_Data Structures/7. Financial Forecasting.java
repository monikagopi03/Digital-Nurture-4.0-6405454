
class Forecast {
    public static double predictFutureValue(double initial, double rate, int years) {
        if (years == 0) return initial;
        return predictFutureValue(initial * (1 + rate), rate, years - 1);
    }

    public static double predictFutureValueOptimized(double initial, double rate, int years) {
        return initial * Math.pow(1 + rate, years);
    }
}