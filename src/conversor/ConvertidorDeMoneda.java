package conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class ConvertidorDeMoneda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseCurrency, targetCurrency;
        double amount;

        // Solicitar divisas y cantidad al usuario
        while (true) {
            try {
                System.out.print("Ingrese la divisa base (ej. USD): ");
                baseCurrency = scanner.nextLine().toUpperCase();

                System.out.print("Ingrese la divisa de destino (ej. EUR): ");
                targetCurrency = scanner.nextLine().toUpperCase();

                System.out.print("Ingrese la cantidad a convertir: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea

                if (amount < 0) {
                    throw new IllegalArgumentException("La cantidad a convertir no puede ser negativa.");
                }
                break; // Salir del ciclo si todo está bien
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }

        // Crear instancia de ApiClient y obtener tasas de cambio
        ApiClient apiClient = new ApiClient();
        String response = apiClient.getExchangeRates(baseCurrency);

        // Comprobar si la respuesta es válida
        if (response != null) {
            // Analizar la respuesta JSON
            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

            if (conversionRates.has(targetCurrency)) {
                double exchangeRate = conversionRates.get(targetCurrency).getAsDouble();
                double convertedAmount = amount * exchangeRate;

                System.out.printf("%.2f %s hoy equivale a %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
            } else {
                System.out.println("Error: No se pudo encontrar la tasa de cambio para la divisa de destino.");
            }
        } else {
            System.out.println("Error al realizar la conversión. Verifique las divisas ingresadas.");
        }

        scanner.close();
    }
}
