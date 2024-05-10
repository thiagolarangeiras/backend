package com.example.noticias.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.noticias.models.Noticia;
import com.example.noticias.services.NoticiasService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class NoticiasController {
    
    public static List<Noticia> noticias = new ArrayList<>();
    
    @Autowired
    private NoticiasService noticiasService;


    @PostMapping("/noticias")
    public ResponseEntity<String> inserirNoticia(@RequestBody Map<String, String> requestBody) {
        String autor = requestBody.get("autor");
        String titulo = requestBody.get("titulo");
        String texto = requestBody.get("texto");
        Noticia noticia = new Noticia(titulo, texto, autor);
        noticias.add(noticia);
        return ResponseEntity.status(HttpStatus.OK).body("Postada com sucesso");
    }

    @GetMapping("/noticias")
    public ResponseEntity<List<Noticia>> lerNoticias() {
        return ResponseEntity.ok(noticias);
    }

    @PutMapping("/noticias/{noticia-id}")
    public ResponseEntity<String> modificarNoticia(@PathVariable("noticia-id") Long noticiaId, @RequestBody Noticia noticiaAlterada) {
        int indexNoticia = noticiasService.findNoticiaById(noticiaId);
        if (indexNoticia < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notícia não encontrada");
        }
        noticias.get(indexNoticia).setTitulo(noticiaAlterada.getTitulo());
        noticias.get(indexNoticia).setTexto(noticiaAlterada.getTexto());
        noticias.get(indexNoticia).setAutor(noticiaAlterada.getAutor());
        noticias.get(indexNoticia).setData(noticiaAlterada.getData());
        return ResponseEntity.ok("Atualizada com sucesso");
    }

    @DeleteMapping("/noticias/{noticia-id}")
    public ResponseEntity<String> excluirNoticia(@PathVariable("noticia-id") Long noticiaId) {
        int indexNoticia = noticiasService.findNoticiaById(noticiaId);
        if (indexNoticia < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notícia não encontrada");
        }
        noticias.remove(indexNoticia);
        return ResponseEntity.ok("Removida com sucesso");
    }
}