package com.example.demo.controllers;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.mappers.ClienteMapper;
import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("{nome}")
    public ClienteDto getCliente(@PathVariable("nome") String nome){
        ClienteDto clienteDto = clienteService.getByNome(nome);
        return clienteDto;
    }
}
