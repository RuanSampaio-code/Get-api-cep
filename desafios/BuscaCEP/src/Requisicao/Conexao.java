package Requisicao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexao {

    private String busca;

    public Conexao(String busca) throws IOException, InterruptedException {
        this.busca = busca;

    }

    public String retornaJson() throws IOException, InterruptedException {

        String endereco = "https://viacep.com.br/ws/" + busca + "/json/";
        HttpClient client = HttpClient.newHttpClient();

       //try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
//        } catch (RuntimeException e) {
//            return null;
//            //System.out.println();
//        }
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
}


