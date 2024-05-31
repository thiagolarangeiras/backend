package com.example.noticias.services;

import org.springframework.stereotype.Service;

import com.example.noticias.controllers.NoticiasController;
import com.example.noticias.models.Noticia;

@Service
public class NoticiasService {
    public int findNoticiaById(Long noticiaId) {
        for (int i = 0; i < NoticiasController.noticias.size(); i++) {
            Noticia noticia = NoticiasController.noticias.get(i);
            if (noticia.getId() == noticiaId) {
                return i; 
            }
        }
        return -1;
    }
}
