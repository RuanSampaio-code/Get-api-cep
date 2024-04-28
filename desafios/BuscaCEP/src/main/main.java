package main;

import GeraArquivo.GeradorDeArquivo;
import Modelos.Endereco;
import Modelos.EnderecoViaCep;
import Requisicao.Conexao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //lista de endereços
        List<Endereco> enderecos = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String busca = "";

        //Precisamos fazer um new GsonBuilder(), dizendo que o nosso título JSON vem com a primeira letra maiúscula, isto é, UPPER_CAMEL_CASE.
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            try {
                System.out.println("Digite o numero do cep: ");
                busca = input.nextLine();

                //saindo do laço
                if (busca.equalsIgnoreCase("sair")){
                    break;
                }

                //Requisição com API
                Conexao conexao = new Conexao(busca);
                String json = conexao.retornaJson();

                //tranformação de Uma class
                EnderecoViaCep enderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
                Endereco meuEndereco = new Endereco(enderecoViaCep);

                //Lista de enderecos
                enderecos.add(meuEndereco);
                System.out.println("Requisição realizada com sucesso");
                System.out.println(meuEndereco);

                //Arquivo

                //Criando aquivo json com os filmes
                GeradorDeArquivo arquivo = new GeradorDeArquivo(enderecos);
                arquivo.salvarArquivo(enderecos);
            } catch (RuntimeException e){
                System.out.println("Erro na requisição");
                System.out.println(e.getMessage());

            }


        }

    }


}
