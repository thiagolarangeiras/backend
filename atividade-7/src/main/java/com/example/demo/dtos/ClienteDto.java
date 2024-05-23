package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record ClienteDto(
    @NotBlank(message = "O nome não pode ser vazio")
    String nome,
    @NotEmpty(message = "O saldo não pode ser vazio")
    Double saldo
) { }
