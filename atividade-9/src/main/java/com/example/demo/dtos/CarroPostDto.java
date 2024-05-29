package com.example.demo.models;

import java.util.UUID;

public record CarroPostDto(
    UUID id,
    String nome,
    String modelo,
    String cor,
    Integer ano,
    Integer kilometragem,
    String nomeDono
) { }