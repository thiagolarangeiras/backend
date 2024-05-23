package com.example.demo.dtos;

import java.time.Instant;

public record ApiExceptionDto(
        String titulo,
        String descricao,
        Instant data
) {
}
