package com.example.noticias.models;

import java.util.Date;

public record NoticiaDto(
    String titulo,
    String texto,
    String autor,
    Date data
) {
    public Noticia newClass() {
        return new Noticia(titulo, texto, autor);
    }

    public void updateClass(Noticia noticia) {
        noticia.setTitulo(this.titulo());
        noticia.setTexto(this.texto());
        noticia.setAutor(this.autor());
        noticia.setData(this.data());
    }
 }
