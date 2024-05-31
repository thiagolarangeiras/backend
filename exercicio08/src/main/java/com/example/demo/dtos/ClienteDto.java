package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(
    @NotBlank(message = "O nome não pode ser vazio")
    String nome,
    @NotNull(message = "O saldo não pode ser vazio")
    Double saldo
) { }
