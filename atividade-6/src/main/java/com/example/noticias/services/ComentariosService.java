package com.example.noticias.services;

import org.springframework.stereotype.Service;

import com.example.noticias.controllers.NoticiasController;
import com.example.noticias.models.Comentario;

@Service
public class ComentariosService {
    public Integer editComentarioById(int indexNoticia, Long comentarioId, String texto) {
        int indexComentario = -1;
        for (int i = 0; i < NoticiasController.noticias.get(indexNoticia).getComentarios().size(); i++) {
            Comentario comentario = NoticiasController.noticias.get(indexNoticia).getComentarios().get(i);
            if (comentario.getId() == comentarioId) {
                indexComentario = i; 
            }
        }
        if(indexComentario > -1)
            NoticiasController.noticias.get(indexNoticia).getComentarios().get(indexComentario).setTexto(texto);
        return indexComentario;
    }

    public Boolean hasExceededCommentLimit(String usuario) {
        if (usuario == "Ramon Venson"){
            return true;
        }
        return false;
    }

    public Integer deleteComentarioById(int indexNoticia, Long comentarioId) {
        int indexComentario = -1;
        for (int i = 0; i < NoticiasController.noticias.get(indexNoticia).getComentarios().size(); i++) {
            Comentario comentario = NoticiasController.noticias.get(indexNoticia).getComentarios().get(i);
            if (comentario.getId() == comentarioId) {
                indexComentario = i; 
            }
        }
        if (indexComentario > -1) 
            NoticiasController.noticias.get(indexNoticia).getComentarios().remove(indexComentario);
        return indexComentario;
    }
}
