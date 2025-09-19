package learn.java8.LearnFunInterfaces.FunctionExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    /**
     * Function will have two arguments
     * Type(T) and Return type(R)
     */

    public static void main(String[] args) {

        /** old way to implement Fuction interface */
        Function<String, Integer> exe1 = new Function<String, Integer>() {

            @Override
            public Integer apply(String t) {
                return t.length();
            }

        };
        System.out.println(exe1.apply("Java Development"));
        System.out.println("old way to implement Fuction interface ended here.... \n");

        /** Slightly modified way to implement Function */

        Function<String, Integer> exe2 = String::length;
        System.out.println(exe2.apply("Java Development"));
        System.out.println("slightly modified way to implement Function ended here.... \n");

        /** utilization of Function interface as a Parameter */

        System.out.println((Integer) FunctionExample.transform("Prashanth", String::length));
        System.out.println("utilization of Function interface as a Parameter ended here.... \n");
        /*
         * Realtime example of Function interface with Stream API map method
         * map method accept Function as argument
         * Creating a list which contains square of given numbers
         */

        Function<Integer, Integer> square = i -> i * i;
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Integer> list = Arrays.stream(arr).map(square::apply).toList();
        System.out.println(list);
        System.out.println("Realtime example of Function interface with Stream API map method ended here.... \n");

    }

    public static <T, R> R transform(T input, Function<T, R> function) {
        return function.apply(input);
    }
}
