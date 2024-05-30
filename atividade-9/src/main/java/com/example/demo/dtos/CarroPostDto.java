package com.example.demo.dtos;

import java.util.UUID;

public record CarroPostDto(
    String nome,
    String modelo,
    String cor,
    Integer ano,
    Integer kilometragem,
    String nomeDono
) { }