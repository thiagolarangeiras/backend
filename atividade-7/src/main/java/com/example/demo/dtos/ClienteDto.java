package com.example.demo.dtos;

import com.example.demo.models.Cliente;

public record ClienteDto(
    String nome,
    Double saldo
) { }
