package thiago;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class OscarService {
    private ArrayList<Indicacao> indicados = new ArrayList<>();

    public void adicionarIndicacao(Indicacao indicacao){
        indicados.add(indicacao);
    }

    public void mostrarListaIndicado(){
        for (Indicacao indicacao : indicados) {
            System.out.println("categoria: " + indicacao.getCategoria());
        }
    }

}
