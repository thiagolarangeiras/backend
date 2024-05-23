package com.example.demo.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record TransacaoDto(
        @NotBlank(message = "O recebedor não pode ser vazio")
        String recebedor,
        @NotBlank(message = "O pagador não pode ser vazio")
        String pagador,
        @NotEmpty(message = "A quantidade não pode ser vazio")
        @Min(value = 0,  message = "O valor deve ser maior do que 0")
        Double quantidade
) { }