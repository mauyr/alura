import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
        System.out.println(dataFutura);

        Period period = Period.between(dataFutura, hoje);
        System.out.println(period);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(hoje.format(formatter));
    }
}
