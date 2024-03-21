import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pokemon {
    private String nome = "";
    private Integer nivel;

    public Pokemon(String nome, Integer nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
