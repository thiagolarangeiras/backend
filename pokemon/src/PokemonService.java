import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    public void capturar(Pokemon pokemon){
        System.out.printf("o Pokemon %s foi capturado", pokemon.getNome());
    }
}