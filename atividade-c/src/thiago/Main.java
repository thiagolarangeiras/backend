package thiago;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        OscarService oscarService  = context.getBean(OscarService.class);
        {
            Indicavel indicavel = context.getBean(Ator.class, true, "Cillian Murphy", "Irlandes");
            Indicacao indicacao = context.getBean(Indicacao.class, indicavel, "Melhor Ator");
            oscarService.adicionarIndicacao(indicacao);
        }
        {
            Indicavel indicavel1 = context.getBean(Filme.class,true, "Oppenheimer", "Cinebiografia");
            Indicavel indicavel2 = context.getBean(Filme.class,true, "American Fiction", "2");

            Indicacao indicacao1 = context.getBean(Indicacao.class, indicavel1, "Melhor filme");
            Indicacao indicacao2 = context.getBean(Indicacao.class, indicavel2, "Melhor filme");
            oscarService.adicionarIndicacao(indicacao1);
            oscarService.adicionarIndicacao(indicacao2);
        }
        oscarService.mostrarListaIndicado();
    }
}