package thiago;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Filme implements Indicavel {
    private Boolean elegivel;
    private Short numeroDeIndicacoes;
    private String nome;
    private String  genero;
    Filme(Boolean elegivel, String nome, String genero){
        this.elegivel = elegivel;
        this.numeroDeIndicacoes = 0;
        this.nome = nome;
        this.genero = genero;
    }

    @Override
    public String getValores(){
        return String.format("Nome: %s\nGenero: %s ", nome, genero);
    }
    @Override
    public Boolean getElegivel() {
        return elegivel;
    }
    @Override
    public Short getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }
    public String getNome() {
        return nome;
    }
    public String getGenero() {
        return genero;
    }
    @Override
    public void setElegivel(Boolean elegivel) {
        this.elegivel = elegivel;
    }
    @Override
    public void setNumeroDeIndicacoes(Short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
