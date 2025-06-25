import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinancialForecast {
    private static Map<String, Double> memo = new HashMap<>();

    public static double calculateForecast(double initialAmount, double[] growthRates, int years) {
        if (years == 0) return initialAmount;
        String key = years + "-" + initialAmount;
        if (memo.containsKey(key)) return memo.get(key);
        double previous = calculateForecast(initialAmount, growthRates, years - 1);
        double currentRate = growthRates[(years - 1) % growthRates.length];
        double forecastedValue = previous * (1 + currentRate);
        memo.put(key, forecastedValue);
        return forecastedValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial investment amount: ");
        double initialAmount = scanner.nextDouble();
        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();
        System.out.print("Enter number of past growth rates: ");
        int n = scanner.nextInt();
        double[] growthRates = new double[n];
        System.out.println("Enter past growth rates (e.g. 0.05 for 5%): ");
        for (int i = 0; i < n; i++) {
            growthRates[i] = scanner.nextDouble();
        }
        double finalValue = calculateForecast(initialAmount, growthRates, years);
        System.out.printf("Forecasted Value after %d years: %.2f\n", years, finalValue);
        scanner.close();
    }
}
