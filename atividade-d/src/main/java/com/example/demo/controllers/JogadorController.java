package com.example.demo.controllers;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.*;

@RestController
public class JogadorController {
    @GetMapping("/GerarJogador")
    public String GerarJogador() {
        String result = "";
        for(int i=0; i<=10; i++){
            result += "\n" + JogadorGerador.NovoJogador().getDescricao();
        }
        System.out.print(result);
        return result;
    }

    @GetMapping("/GerarJogadorJson")
    public Jogador GerarJogadorJson() {
        return JogadorGerador.NovoJogador();
    }
}