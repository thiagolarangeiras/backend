package com.example.demo.controllers;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("{nome}")
    public ResponseEntity<Object> getCliente(@PathVariable("nome") String nome){
        ClienteDto clienteDto = clienteService.getByNome(nome);
        return ResponseEntity.status(200).body(clienteDto);
    }
}
