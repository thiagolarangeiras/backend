package com.example.noticias.controllers;

import java.util.List;
import java.util.Map;

import com.example.noticias.models.Comentario;
import com.example.noticias.models.ComentarioDto;
import com.example.noticias.models.Noticia;

import com.example.noticias.services.ComentariosService;
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
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;
    @Autowired
    private NoticiasService noticiasService;

    @PostMapping("/noticias/{noticia-id}/comentarios")
    public ResponseEntity<String> inserirComentario(@PathVariable("noticia-id") Long noticiaId, @RequestBody ComentarioDto dto) {
        Comentario comentario = dto.newClass();
        int indexNoticia = noticiasService.findNoticiaById(noticiaId);
    
        if (indexNoticia < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há uma notícia com este id");
        }
        if (comentariosService.hasExceededCommentLimit(comentario.getUsuario())) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Muitos comentários feitos pelo mesmo usuário");
        }
        if (comentario.getTexto().length() < 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de caracteres mínimos não atendidos (mínimo 3)");
        }
        if (comentario.getTexto().length() > 512) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de caracteres máximos ultrapassados (máximo 300)");
        }

        NoticiasController.noticias.get(indexNoticia).addComentario(comentario);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Comentário criado");
    }

    @GetMapping("/noticias/{noticia-id}/comentarios")
    public ResponseEntity<List<Comentario>> lerComentarios(@PathVariable("noticia-id") Long noticiaId) {
        int indexNoticia = noticiasService.findNoticiaById(noticiaId);
        return ResponseEntity.ok(NoticiasController.noticias.get(indexNoticia).getComentarios());
    }
    @PutMapping("/noticias/{noticia-id}/comentarios/{comentario-id}")
    public ResponseEntity<String> modificarComentario(@PathVariable("noticia-id") Long noticiaId, @PathVariable("comentario-id") Long comentarioId, @RequestBody ComentarioDto dto) {
        int indexNoticia = noticiasService.findNoticiaById(noticiaId);
        if( comentariosService.editComentarioById(indexNoticia, comentarioId, dto.texto()) <= -1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há um comentario com este id");
        }
        return ResponseEntity.ok("Atualizado com sucesso");
    }
    @DeleteMapping("/noticias/{noticia-id}/comentarios/{comentario-id}")
    public ResponseEntity<String> excluirComentario(@PathVariable("noticia-id") Long noticiaId, @PathVariable("comentario-id") Long comentarioId) {
        int indexNoticia = noticiasService.findNoticiaById(noticiaId);
        if ( comentariosService.deleteComentarioById(indexNoticia, comentarioId) <= -1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há um comentario com este id");
        }
        return ResponseEntity.ok("Removida com sucesso");
    }
}
