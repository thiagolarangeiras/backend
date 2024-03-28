package thiago;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OscarService {
    private ArrayList<Indicacao> indicados = new ArrayList<>();

    public void adicionarIndicacao(Indicacao indicacao){
        indicados.add(indicacao);
    }

    public void mostrarListaIndicado(){
        for (Indicacao indicacao : indicados) {
            System.out.printf(
                    "%s\nNumero de indicações: %s\nCategoria da indicaçao: %s\n\n",
                    indicacao.getIndicavel().getValores(),
                    indicacao.getIndicavel().getNumeroDeIndicacoes(),
                    indicacao.getCategoria()
            );
        }
    }

}
