import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseCurrency = "MXN";

        System.out.println("===== Conversor de Moneda =====");
        System.out.println("1. Convertir de MXN a USD");
        System.out.println("2. Convertir de USD a MXN");
        System.out.println("3. Convertir de MXN a EUR");
        System.out.println("4. Convertir de EUR a MXN");
        System.out.print("Seleccione una opción (1-4): ");

        int option = scanner.nextInt();
        String targetCurrency = "";

        switch (option) {
            case 1 -> targetCurrency = "USD";
            case 2 -> {
                baseCurrency = "USD";
                targetCurrency = "MXN";
            }
            case 3 -> targetCurrency = "EUR";
            case 4 -> {
                baseCurrency = "EUR";
                targetCurrency = "MXN";
            }
            default -> {
                System.out.println("Opción no válida.");
                return;
            }
        }

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        Map<String, Double> rates = CurrencyConverter.getRates(baseCurrency);
        if (rates != null && rates.containsKey(targetCurrency)) {
            double rate = rates.get(targetCurrency);
            double result = CurrencyConverter.convertCurrency(amount, rate);
            System.out.printf("Resultado: %.2f %s son %.2f %s%n", amount, baseCurrency, result, targetCurrency);
        } else {
            System.out.println("Error: No se pudo obtener la tasa de cambio para la conversión solicitada.");
        }
    }
}
