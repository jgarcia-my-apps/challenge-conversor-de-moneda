package conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioTasasDeCambio {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/c2326d95cb1eab980fc8fd30/latest/USD";
    private Gson gson = new Gson();

    public RespuestaTasaCambio obtenerTasas() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        // Imprimir respuesta cruda de la API para depurar
        System.out.println("Respuesta cruda de la API: " + respuesta.body());

        // Verificar si el código de estado es 200 (éxito)
        if (respuesta.statusCode() != 200) {
            System.out.println("Error en la API: " + respuesta.statusCode());
            return null;
        }

        // Convertir JSON en objeto Java
        RespuestaTasaCambio tasasDeCambio = gson.fromJson(respuesta.body(), RespuestaTasaCambio.class);

        // Verificar si el campo rates es null
        if (tasasDeCambio.getConversion_rates() == null) {
            System.out.println("El campo 'conversion_rates' es null en la respuesta de la API.");
            return null;
        }

        return tasasDeCambio;
    }
}
