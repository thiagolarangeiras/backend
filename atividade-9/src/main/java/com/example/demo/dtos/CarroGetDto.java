package com.example.demo.models;

import java.util.UUID;

public record CarroGetDto(
    UUID id,
    String nome,
    String modelo,
    String cor,
    Integer ano,
    Integer kilometragem
) { }