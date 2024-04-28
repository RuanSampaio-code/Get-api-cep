package GeraArquivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    private List listaDeEnderecos;

    public GeradorDeArquivo(List listDeEnderecos) {
        this.listaDeEnderecos = listDeEnderecos;
    }

    public void salvarArquivo(List listaDeEnderecos) throws IOException {


        //Precisamos fazer um new GsonBuilder(), dizendo que o nosso título JSON vem com a primeira letra maiúscula, isto é, UPPER_CAMEL_CASE.
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escrita = new FileWriter("ceps.json");
        escrita.write(gson.toJson(listaDeEnderecos));
        escrita.close();

        System.out.println("Arquivo json criado");

    }

    public List getListDeEnderecos() {
        return listaDeEnderecos;
    }
}
