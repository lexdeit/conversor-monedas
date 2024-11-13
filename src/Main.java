import java.util.List;
import java.util.Scanner;

public class Main {
    // Lista de monedas disponibles para la conversión
    private static final List<String> currencies = List.of("MXN", "USD", "EUR", "AUD", "NZD", "AED", "CAD");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        System.out.println("===== Bienvenido al Conversor de Moneda =====");

        while (continueConversion) {
            System.out.println("\nSeleccione la moneda de origen:");
            String fromCurrency = selectCurrency(scanner);

            System.out.println("Seleccione la moneda de destino:");
            String toCurrency = selectCurrency(scanner);

            System.out.print("Ingrese la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            ConversionResult result = CurrencyConverter.getConversion(fromCurrency, toCurrency, amount);

            if (result != null && "success".equals(result.getResult())) {
                System.out.printf("Resultado: %.2f %s son %.2f %s (Tasa: %.4f)%n",
                        amount, fromCurrency, result.getConversionResult(), toCurrency, result.getConversionRate());
            } else {
                System.out.println("Error: No se pudo obtener la tasa de cambio para la conversión solicitada.");
            }

            // Pregunta si el usuario desea realizar otra conversión o salir
            System.out.println("\n¿Desea realizar otra conversión?");
            System.out.println("1. Sí");
            System.out.println("2. No, salir");

            int option;
            do {
                System.out.print("Seleccione una opción: ");
                option = scanner.nextInt();
            } while (option != 1 && option != 2);

            // Si elige "2", termina el bucle
            continueConversion = option == 1;
        }

        System.out.println("Gracias por usar el Conversor de Moneda. ¡Hasta luego!");
    }

    private static String selectCurrency(Scanner scanner) {
        // Muestra el menú de monedas de la lista y devuelve la moneda seleccionada
        for (int i = 0; i < currencies.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, currencies.get(i));
        }

        int choice;
        do {
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > currencies.size());

        return currencies.get(choice - 1);
    }
}
