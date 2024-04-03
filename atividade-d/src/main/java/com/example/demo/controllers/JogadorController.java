package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.*;

@RestController
public class JogadorController {
    @GetMapping("/GerarJogador")
    public String GerarJogador() {
        return JogadorGerador.NovoJogador().getDescricao();
    }

    @GetMapping("/GerarJogadorJson")
    public Jogador GerarJogadorJson() {
        return JogadorGerador.NovoJogador();
    }
}