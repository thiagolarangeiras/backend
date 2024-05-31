package com.example.demo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CarroPostDto(
        @NotEmpty String nome,
        @NotEmpty String modelo,
        @NotEmpty String cor,
        @NotNull Integer ano,
        @NotNull Integer kilometragem,
        @NotEmpty String nomeDono
) { }