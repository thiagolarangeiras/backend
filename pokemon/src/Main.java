import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Pokemon pokemon = context.getBean(Pokemon.class, "CHARMANDDER", 12);
        System.out.printf(pokemon.getNome());
    }
}