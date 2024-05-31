package com.example.noticias.models;

import java.util.*;
import com.example.noticias.models.Comentario;

public class Noticia {
    private static Long proximoId = 1L;
    private Long id;
    private String titulo;
    private String texto;
    private String autor;
    private Date data;
    private List<Comentario> comentarios = new ArrayList<>();
    ;

    public Noticia(String titulo, String texto, String autor) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.data = new Date();
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Long getId() {
        return id;
    }
    public List<Comentario> getComentarios() {
        return comentarios;
    }
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }
}
