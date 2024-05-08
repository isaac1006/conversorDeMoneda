import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {

    public OptenerMoneda optenerMoneda(String monedaBuscada){
        URI direccion=URI.create("https://v6.exchangerate-api.com/v6/518073158a47032e890a10a4/latest/"+monedaBuscada);
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response= client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Utilizar TypeToken para mapear correctamente el JSON
            TypeToken<OptenerMoneda> token = new TypeToken<OptenerMoneda>() {};
            OptenerMoneda data = new Gson().fromJson(response.body(), token.getType());
           // return new Gson().fromJson(response.body(),OptenerMoneda.class);
            return data;
        }catch (IOException | InterruptedException e){
            throw new RuntimeException("No es posible encontrar moneda");
        }
    }
}
