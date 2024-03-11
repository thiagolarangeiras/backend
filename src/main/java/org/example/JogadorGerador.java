package org.example;

import java.util.Random;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class JogadorGerador {
    private static final String nome_uri = "/nomes.txt";
    private static final String sobreNome_uri = "/sobrenomes.txt";
    private static final String posicao_uri = "/posicoes.txt";
    private static final String clube_uri = "/clubes.txt";

    private static String retornaElementoAleatorio(String[] elementos) {
        int indice = new Random().nextInt(0, elementos.length);
        return elementos[indice];
    }

    private static String chamar(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String value = response.body();
        return retornaElementoAleatorio(value.split("\n"));
    }

    private static int gerarIdadeAleatoria(int minima, int maxima) {
        if (minima < 0)
            minima = 0;
        if (maxima > 200)
            maxima = 200;
        return new Random().nextInt(minima, maxima + 1);
    }

    public static Jogador NovoJogador(String uri) throws Exception {
        String nome = chamar(uri + nome_uri);
        String sobrenome = chamar(uri + sobreNome_uri);
        String posicao = chamar(uri + posicao_uri);
        String clube = chamar(uri + clube_uri);
        posicao = posicao.replace("\"", "").replace(",", "");
        return new Jogador(nome, sobrenome, gerarIdadeAleatoria(17, 40), posicao, clube);
    }

}