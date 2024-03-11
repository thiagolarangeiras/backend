package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Jogador jogador = JogadorGerador.NovoJogador("https://venson.net.br/resources/data");
        System.out.printf(jogador.getDescricao());
    }
}