import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {

    public OptenerMoneda optenerMoneda(String moneda){
        URI direccion=URI.create("https://v6.exchangerate-api.com/v6/518073158a47032e890a10a4/latest/"+moneda);
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response= client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),OptenerMoneda.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException("No es posible encontrar moneda");
        }
    }
}
