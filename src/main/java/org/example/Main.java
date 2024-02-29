package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static final String nomes_uri = "https://venson.net.br/resources/data/nomes.txt";
    static final String sobrenomes_uri =  "https://venson.net.br/resources/data/sobrenomes.txt";
    static final String clubes_uri = "https://venson.net.br/resources/data/clubes.txt";
    static final String posicoes_uri = "https://venson.net.br/resources/data/posicoes.txt";

    public static String retornaElementoAleatorio(String[] elementos) throws Exception{
        int indice = (int) Math.floor(Math.random() * elementos.length);
        return elementos[indice];
    }

    public static String chamar(String uri) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String value = response.body();
        return retornaElementoAleatorio(value.split("\n"));
    }

    public static void main(String[] args) throws Exception{
        String nome = chamar(nomes_uri);
        String sobrenome = chamar(sobrenomes_uri);
        String clube = chamar(clubes_uri);
        String posicao = chamar(posicoes_uri);
        posicao = posicao.replace("\"","").replace(",","");

        Random rand = new Random();
        int idade = rand.nextInt(17, 41);

        System.out.printf("%S %S é um futebolista brasileiro de %d anos que atua como %S. Atualmente defende o %S.",
            nome, sobrenome, idade, posicao, clube);
    }
}