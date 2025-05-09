package buscadorCep;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepService {

//        URI endereco = "https://viacep.com.br/ws/" + Cep + "/jsono";

//        private static final String BASE_URL = "https://viacep.com.br/ws/%s/json/;"

        public Cep buscarCep(String cep) {
                URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

//                String url = String.format(BASE_URL, cep);
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(endereco)
                        .GET()
                        .build();

                try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        if(response.statusCode() == 200) {
                                Gson gson = new Gson();
                                return gson.fromJson(response.body(), Cep.class);
                        } else {
                                System.out.println("Erro ao buscar CEP" + response.statusCode());
                        }

                } catch (IOException | InterruptedException e) {
                        System.out.println("Erro ao fazer requisição do CEP" + e.getMessage());
                        System.out.println("Finalizando a aplicação");
                }
                return null;
        }

}
