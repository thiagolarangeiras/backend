package thiago;

import org.springframework.stereotype.Component;

@Component
public class Ator implements Indicavel {
    private String nome;
    private String nacionalidade;
    
    Ator(String nome, String nacionalidade){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }    
}
