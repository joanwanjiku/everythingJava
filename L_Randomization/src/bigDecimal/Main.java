package bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double policyAmount = 100_000_000;
        int ben = 3;
        float percentageFloat = 1.0f /ben;
        double percentage = 1.0 /ben;
        System.out.printf("Percentage: %,.2f ", policyAmount * percentage);
        System.out.printf("Percentage: %,.2f", policyAmount * percentageFloat);
        System.out.println("\n----------------------------------");
        double totalUsingFloat = policyAmount - ((policyAmount * percentageFloat) * ben);
        System.out.printf("totalUsingFloat: %.2f", totalUsingFloat);
        System.out.println("\n----------------------------------");
        double totalUsingDouble = policyAmount - ((policyAmount * percentage) * ben);
        System.out.printf("totalUsingDouble: %.2f", totalUsingDouble);

        System.out.println("\n------------------------------------------------------------------------");
        String[] tests = {"15.456", "8", "10000.00001", ".123"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled", "Scale", "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        System.out.println("\n------------------------------------------------------------------------");
        double[] doubles = {15.456, 8, 10000.00001, .123};
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i]));
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled", "Scale", "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.printf("%-15s %-15d %-8d %d %n", bd, bd.unscaledValue(), bd.scale(), bd.precision());

        }

    }
}
