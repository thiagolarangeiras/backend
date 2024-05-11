package com.example.noticias.models;

import java.util.Date;

public record ComentarioDto(
    String usuario,
    String texto,
    Date data
) {
    public Comentario newClass(){
        return new Comentario(usuario, texto);
    }

    // Comentario toUpdateDto() {
    //     return ;
    // }
}