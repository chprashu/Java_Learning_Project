package learn.java8.LearnStreamAPI;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExample {

        /**
         * Stream API is a streaming of data which contains source, intermediate and
         * terminal operations to
         * to perform a task
         * 
         * source helps to create a Stream by using methods like
         * stream(), parallelStream()
         * 
         * 
         * intermediate ops helps to do certain opertaions like filter(), sort(), map(),
         * flatMap(), sorted(), limit(), skip() etc.
         * intermediate operations works lazily, and calls once termila opertaion calls
         * 
         * 
         * terminal ops helps to terminate the Stream by giving the desired output
         * like collect(), forEach(), count(), reduce(), min(), max(), allMatch(),
         * anyMatch() etc
         * 
         * collect() can performed verious collectors like
         * toList(), toSet(), joining(), groupingBy(), partitionBy(), mapping()
         * 
         */

        @SuppressWarnings("unused")
        public static void main(String[] args) {

                List<String> courses = List.of("java", "python", "javascript", "php", "dotnet", "golang", "c#", "c++",
                                "c");

                Stream<String> stream1 = courses.stream(); // creating a source(Stream) using stream
                Stream<String> stream2 = courses.parallelStream(); // creating a source(Stream) using parallelStream

                /**
                 * problem 1: create stream of data which should return array of String, string
                 * should follow below conditions
                 * filter strings which are having length greater than 3
                 * make strings to uppercase
                 * sort strings array
                 * store them in list
                 */
                Stream<String> prob1Array = courses.stream(); // creating source

                /** Intermadiate Operations */
                List<String> resList = prob1Array
                                .filter(x -> x.length() >= 3)
                                .map(String::toUpperCase)
                                .sorted()
                                /** Terminal Opertaions */
                                .collect(Collectors.toList()); // converting stream to list

                /**
                 * if we already consumed stream using terminal opertaions then we can't consume
                 * it again
                 * else throw illegalStateExecption with msg: stream has already been operated
                 * upon or closed
                 */
                // prob1Array.forEach(x -> System.out.println(x));
                resList.forEach(x -> System.out.println(x));
                System.out.println('\n');

                /**
                 * Problem 2: Print all strings that contain the letter 'a', in lowercase,
                 * sorted
                 */
                courses.stream() // creating a source
                                .filter(x -> x.contains("a")) // intermediate ops1
                                .map(String::toLowerCase) // intermediate ops2
                                .sorted() // intermediate ops2
                                .forEach(x -> System.out.println(x)); // terminal ops
                System.out.println('\n');

                /**
                 * Problem 3:From a list of numbers, get only unique odd numbers, skip first 2,
                 * and limit to 3.
                 */
                List<Integer> numbers = List.of(2, 5, 4, 7, 1, 1, 5, 8, 2, 9, 10, 17, 11, 34, 21, 7, 3, 9, 13, 17);
                numbers.stream()
                                .skip(2)
                                .distinct()
                                .filter(x -> x % 2 > 0)
                                .limit(3)
                                .sorted()
                                .forEach(x -> System.out.println(x));
                System.out.println('\n');

                /**
                 * Problem 4: Count how many strings in a list start with 'J'
                 */
                long count = courses.stream()
                                .filter(x -> x.startsWith("j"))
                                .count();
                System.out.println(count + "\n");

                /**
                 * Problem 5: Print the longest string from a list using streams.
                 */
                courses.stream()
                                .sorted((x, x1) -> ((Integer) x1.length()).compareTo(((Integer) x.length())))
                                .limit(1)
                                .forEach(x -> System.out.println(x));
                System.out.println('\n');

                /**
                 * Problem 6: Generate a list of 5 random integers between 1–100 using
                 * Stream.generate().
                 */
                List<Integer> randomInts = Stream.generate(() -> new Random()
                                .nextInt(100) + 1)
                                .limit(5)
                                .collect(Collectors.toList());
                randomInts.forEach(x -> System.out.println(x));
                System.out.println('\n');

                List<String> alphs = List.of("A", "E", "C", "D", "B", "F", "G");
                alphs.stream().sorted((o1, o2) -> o1.compareTo(o2)).forEach(System.out::print);

        }
}