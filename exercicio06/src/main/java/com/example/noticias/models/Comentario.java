package com.example.noticias.models;

import java.util.Date;

public class Comentario {
    private static Long proximoId = 1L;
    private Long id;
    private String usuario;
    private String texto;
    private Date data;

    public Comentario(String usuario, String texto) {
        this.id = proximoId++;
        this.usuario = usuario;
        this.texto = texto;
        this.data = new Date();
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
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
}
