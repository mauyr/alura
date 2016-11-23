import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mauyr on 23/11/16.
 */
public class DefaultMethods {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        palavras.sort(Comparator.comparing(s -> s.charAt(2)));

        palavras.forEach(System.out::println);

        new Thread(() -> {
            System.out.println("Executando um Runnable");
        }).start();
    }
}
