package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Jogador {
    private String nome;
    private String sobreNome;
    private int idade;
    private String posicao;
    private String clube;

    public Jogador(String nome, String sobreNome, int idade, String posicao, String clube) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.posicao = posicao;
        this.clube = clube;
    }

    // Get
    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClube() {
        return clube;
    }

    // Set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    // Metodos
    public String getDescricao() {
        return String.format("%S %S é um futebolista brasileiro de %d anos que atua como %S. Atualmente defende o %S.",
                nome, sobreNome, idade, posicao, clube);
    }

}