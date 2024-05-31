package thiago;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ator implements Indicavel {
    private Boolean elegivel;
    private Short numeroDeIndicacoes;
    private String nome;
    private String nacionalidade;
    
    Ator(Boolean elegivel, String nome, String nacionalidade){
        this.elegivel = elegivel;
        this.numeroDeIndicacoes = 0;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String getValores(){
        return String.format("Nome: %s\nNacionalidade: %s ", nome, nacionalidade);
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
    public String getNacionalidade() {
        return nacionalidade;
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
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
