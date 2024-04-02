package com.example.demo;

import java.util.Random;
import org.springframework.stereotype.Component;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;

@Component
public class JogadorGerador {
    private static final String uri = "https://venson.net.br/resources/data";
    private static final String nome_uri      = uri + "/nomes.txt";
    private static final String sobreNome_uri = uri + "/sobrenomes.txt";
    private static final String posicao_uri   = uri + "/posicoes.txt";
    private static final String clube_uri     = uri + "/clubes.txt";

    private static String[] nomes;
    private static String[] sobrenomes;
    private static String[] posicoes;
    private static String[] clubes;

    private static String retornaElementoAleatorio(String[] elementos) {
        int indice = new Random().nextInt(0, elementos.length);
        return elementos[indice];
    }

    private static String[] chamar(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String value = response.body();
        return value.split("\n");
    }

    private static int gerarIdadeAleatoria(int minima, int maxima) {
        if (minima < 0)
            minima = 0;
        if (maxima > 200)
            maxima = 200;
        return new Random().nextInt(minima, maxima + 1);
    }

    public static void RecuperarDadosJogadores() throws IOException, InterruptedException {
        nomes = chamar(nome_uri);
        sobrenomes = chamar(sobreNome_uri);
        posicoes = chamar(posicao_uri);
        clubes = chamar(clube_uri);
        
        for (int i=0; i<posicoes.length; i++) {
            posicoes[i] = posicoes[i].replace("\"", "").replace(",", "");
        }
    }

    public static Jogador NovoJogador() {
        String nome = retornaElementoAleatorio(nomes);
        String sobrenome = retornaElementoAleatorio(sobrenomes);
        String posicao = retornaElementoAleatorio(posicoes);
        String clube = retornaElementoAleatorio(clubes);
        return new Jogador(nome, sobrenome, gerarIdadeAleatoria(17, 40), posicao, clube);
    }
}
