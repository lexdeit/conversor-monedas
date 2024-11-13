import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/2e648cba8eb989bec015d14b/pair/";

    public static ConversionResult getConversion(String fromCurrency, String toCurrency, double amount) {
        try {
            URL url = new URL(API_URL + fromCurrency + "/" + toCurrency + "/" + amount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                Gson gson = new Gson();
                ConversionResult result = gson.fromJson(reader, ConversionResult.class);
                reader.close();
                return result;
            } else {
                System.out.println("Error: No se pudo obtener la tasa de cambio.");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }
        return null;
    }
}
