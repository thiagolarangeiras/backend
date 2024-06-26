package com.example.demo.controllers;

import com.example.demo.dtos.CarroGetDto;
import com.example.demo.dtos.CarroPostDto;
import com.example.demo.services.CarroService;
import com.example.demo.validators.CustomNotEmpty;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("carro")
public class CarroController {
    @Autowired
    CarroService carroService;

    @GetMapping("{id-carro}")
    public ResponseEntity<Object> getCarro(@PathVariable("id-carro") UUID idCarro){
        CarroGetDto dto = carroService.get(idCarro);
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCarro(
            @RequestParam("pagina") @Min(0) int pagina,
            @RequestParam("qtde") @Min(5) @Max(200) int qtde,
            @RequestParam("sort") @Nullable @CustomNotEmpty List<String> sort,
            @RequestParam("nome") @Nullable @CustomNotEmpty String nome
    ){
        List<CarroGetDto> dtos = carroService.getAll(pagina, qtde, sort, nome);
        return ResponseEntity.status(200).body(dtos);
    }

    @PostMapping
    public ResponseEntity<Object> postCarro(@RequestBody @Valid CarroPostDto dto){
        CarroGetDto dtoResult = carroService.post(dto);
        return ResponseEntity.status(201).body(dtoResult);
    }

    @PutMapping("{id-carro}")
    public ResponseEntity<Object> putCarrp(
            @PathVariable("id-carro") UUID idCarro,
            @RequestBody CarroPostDto dto)
    {
        CarroGetDto dtoResult = carroService.put(idCarro, dto);
        return ResponseEntity.status(200).body(dtoResult);
    }

    @DeleteMapping("{id-carro}")
    public ResponseEntity<Object> getCliente(@PathVariable("id-carro") UUID idCarro){
        CarroGetDto dtoResult = carroService.delete(idCarro);
        return ResponseEntity.status(200).body(dtoResult);
    }
}