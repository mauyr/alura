package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        cursos.stream().filter(c -> c.getAlunos()>=50).map(Curso::getNome).forEach(System.out::println);

        System.out.println(cursos.stream().filter(c -> c.getAlunos()>=50).findFirst().orElseGet(null).getNome());

        System.out.println(cursos.stream().mapToLong(Curso::getAlunos).average().getAsDouble());

        System.out.println(cursos.stream().filter(c -> c.getAlunos()>=50).collect(Collectors.toList()));
    }
}
