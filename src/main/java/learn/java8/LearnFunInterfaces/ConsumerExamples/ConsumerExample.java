package learn.java8.LearnFunInterfaces.ConsumerExamples;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerExample {
    /**
     * Consumer returns no result.
     * It is typically used for:
     * - Logging
     * - Printing
     * - Performing actions on objects without returning a value
     * - Consuming values in Streams API forEach method to perform actions on each
     * element.
     */

    public static void main(String[] args) {

        /*
         * implementing consumer in old way
         */
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello " + name);
            }
        };
        c1.accept("Prashanth");

        /*
         * implementing consumer using lambda
         */
        Consumer<String> c2 = str -> System.out.println("hi, " + str);
        c2.accept("Harish");

        /*
         * implementing consumer using method reference
         * where andThen is used to chain consumers
         */
        implAndThen();

        /*
         * This is about how we can use consumer in Stream API forEach method
         * with an example of making square of each element in an array
         */
        Consumer<Integer> square = x -> System.out.println("Square of :" + x + " is " + (x * x));
        Integer[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Array: " + Arrays.toString(arr));
        Arrays.stream(arr).forEach(square);
    }

    /**
     * Consumer default methods are
     * andThen
     */
    private static void implAndThen() {
        Consumer<String> c1 = s -> System.out.println("Hello " + s);
        Consumer<String> c2 = s -> System.out.println("Email sent successfully " + s);

        Consumer<String> finalRes = c1.andThen(c2);
        finalRes.accept("Prashanth");

    }
}
