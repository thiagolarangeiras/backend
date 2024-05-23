package com.example.demo.controllers;

import com.example.demo.dtos.TransacaoDto;
import com.example.demo.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity postTransacao(@RequestBody TransacaoDto transacaoDto){
        transacaoService.insert(transacaoDto);
        return ResponseEntity.ok("");
    }
}
