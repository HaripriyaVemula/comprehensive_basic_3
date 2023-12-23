import java.util.Scanner;

public class IT_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your taxable income: $");
        double taxableIncome = scanner.nextDouble();

        double taxPaidPerYear = calculateTax(taxableIncome);
        double taxPayablePerMonth = taxPaidPerYear / 12;

        System.out.println("Tax payable per year: $" + taxPaidPerYear);
        System.out.println("Tax payable per every month: $" + taxPayablePerMonth);
    }

    public static double calculateTax(double taxableIncome) {
        double tax;

        if (taxableIncome <= 25000) {
            tax = 0;
        } else if (taxableIncome <= 50000) {
            tax = 0.1 * (taxableIncome - 25000);
        } else if (taxableIncome <= 75000) {
            tax = 2500 + 0.2 * (taxableIncome - 50000);
        } else {
            tax = 7500 + 0.3 * (taxableIncome - 75000);
        }

        return tax;
    }
}
