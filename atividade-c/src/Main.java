package thiago;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        OscarService oscarService  = context.getBean(OscarService.class);

        for (int i = 0; i < 10; i++) {
            Indicavel indicavel1 = context.getBean(Ator.class, "Cillian Murphy", "Irlandes");
            Indicavel indicavel2 = context.getBean(Filme.class, "Oppenheimer", "Cinebiografia");
            Indicacao indicacao1 = context.getBean(Indicacao.class, indicavel1, "Melhor Ator");
            oscarService.adicionarIndicacao(indicacao1);
        }

        // Pokemon pokemon = new Pokemon("CHARMANDER", 15);
    }
}