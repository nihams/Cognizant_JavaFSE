public class FinancialForecasting {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }

        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    //with memoization
    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        double result = calculateFutureValueMemo(presentValue * (1 + growthRate), growthRate, years - 1, memo);
        memo[years] = result;
        return result;
    }

    public static void main(String[] args) {

        double initialInvestment = 100000;
        double annualGrowthRate = 0.08;
        int yearsToForecast = 10;

        System.out.println("=== Financial Forecasting (Recursive) ===");
        System.out.println("Initial Investment : " + initialInvestment);
        System.out.println("Annual Growth Rate  : " + (annualGrowthRate * 100) + "%");
        System.out.println("Years to Forecast   : " + yearsToForecast);

        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, yearsToForecast);
        System.out.printf("Predicted Future Value after %d years: %.2f%n", yearsToForecast, futureValue);

        System.out.println("\n--- Year by Year Forecast ---");
        for (int year = 0; year <= yearsToForecast; year++) {
            double value = calculateFutureValue(initialInvestment, annualGrowthRate, year);
            System.out.printf("Year %2d: %.2f%n", year, value);
        }

        System.out.println("\n--- Comparing Different Growth Rates (10 years) ---");
        double[] rates = { 0.05, 0.08, 0.12 };
        for (double rate : rates) {
            double fv = calculateFutureValue(initialInvestment, rate, yearsToForecast);
            System.out.printf("Growth Rate %.0f%%: Future Value = %.2f%n", rate * 100, fv);
        }
    }
}
