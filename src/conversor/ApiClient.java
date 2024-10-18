package conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiClient {
    private static final String API_KEY = "c2326d95cb1eab980fc8fd30"; // Tu clave de API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public String getExchangeRates(String baseCurrency) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL + baseCurrency))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Manejo de la respuesta
            int statusCode = response.statusCode(); // Obtiene el código de estado

            if (statusCode == 200) {
                // Obtener el cuerpo de la respuesta en formato JSON
                String jsonResponse = response.body();

                // Escribir la respuesta JSON en un archivo
                writeResponseToFile(jsonResponse, baseCurrency);
                return jsonResponse; // Retorna el cuerpo de la respuesta
            } else {
                // Manejo de errores
                System.out.println("Error: " + response.body()); // Imprime el cuerpo de respuesta para el error
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al realizar la solicitud a la API: " + e.getMessage());
            return null;
        }
    }

    private void writeResponseToFile(String jsonResponse, String baseCurrency) {
        try {
            // Definir la ruta del archivo
            String fileName = "exchange_rates_" + baseCurrency + ".json"; // Nombre del archivo
            Path filePath = Paths.get(fileName);

            // Escribir el contenido JSON en el archivo
            Files.writeString(filePath, jsonResponse);
            System.out.println("Respuesta escrita en el archivo: " + filePath.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
