package learn.java8.LearnStreamAPI.IntermediateOpsMethods;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterMethodExample {

    /**
     * filter accepts Predicate as a argument
     * and returns Stream<T>
     * filter(Predicate<T> p)
     */

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "JavaScript", "Python", "Hibernate", "GoLang", "Function", "Hello",
                "Google", "Geeks");

        /** Implementing everything by definition */
        Stream<String> stream1 = courses.stream();

        Predicate<String> Predicate1 = (s) -> s.contains("J"); // Predicate which will return true if String contains J
        stream1.filter(Predicate1).forEach(System.out::println);
        System.out.println();

        /** defining predicate as a argument */
        courses.stream().filter(s -> s.contains("J")).forEach(System.out::println);
        System.out.println();
    }
}
