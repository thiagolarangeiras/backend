package thiago;

import org.springframework.stereotype.Component;

@Component
public class Filme implements Indicavel {
    private String nome;
    private String  genero;

    Filme(String nome, String genero){
        this.nome = nome;
        this.genero = genero;
    }
    
    public String getGenero() {
        return genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
