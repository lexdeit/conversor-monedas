import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class CurrencyConverter {

    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    public static Map<String, Double> getRates(String baseCurrency) {
        try {
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                Gson gson = new Gson();
                CurrencyRates rates = gson.fromJson(reader, CurrencyRates.class);
                reader.close();
                return rates.getRates();
            } else {
                System.out.println("Error: No se pudo obtener la tasa de cambio.");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }
        return null;
    }

    public static double convertCurrency(double amount, double rate) {
        return amount * rate;
    }
}