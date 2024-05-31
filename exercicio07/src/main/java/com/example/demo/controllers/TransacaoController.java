package com.example.demo.controllers;

import com.example.demo.dtos.TransacaoDto;
import com.example.demo.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")
@Validated
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;


    @GetMapping
    public ResponseEntity getTransacao(){
        return ResponseEntity.status(200).body(transacaoService.transacaoMap);
    }

    @PostMapping
    public ResponseEntity postTransacao(@Valid @RequestBody TransacaoDto transacaoDto){
        transacaoService.insert(transacaoDto);
        return ResponseEntity.ok("Ok");
    }
}
