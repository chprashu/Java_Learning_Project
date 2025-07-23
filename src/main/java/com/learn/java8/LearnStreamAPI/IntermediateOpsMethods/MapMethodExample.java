package com.learn.java8.LearnStreamAPI.IntermediateOpsMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapMethodExample {

    /*
     * map accepts Function as an argument
     * return lazy Stream
     * map(Function<T, R>)
     */

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2, 4, 5, 7, 12, 23, 54, 12, 34, 6);

        /*
         * Using map print squares of all numbers
         */
        numbers.stream().map(i -> i * i).forEach(System.out::println);
        System.out.println();

        /*
        Using map print square root of all numbers
         */
        numbers.stream().map(Math::sqrt).forEach(System.out::println);
        System.out.println();

        /*
        Convert a list of full names ("John Doe") into just first names.
         */
        List<String> fullNames = List.of("Jhon Cina", "Mary Kom", "Randy Otan", "Jhon Doe", "Jhony Deff", "Elon Musk");
        fullNames.stream().map(str -> str.split(" ")[0]).forEach(System.out::println);
        System.out.println();

        /*
        Transform a list of strings into a list of their character counts.
         */
        fullNames.stream().
                map(name -> (int) name.chars().
                        filter(Character::isLetter).
                        count()).
                forEach(System.out::println);
        System.out.println();

        /*
        Convert a list of strings into a list of Optional<String>.
         */
        fullNames.stream().map(Optional::of).forEach(System.out::println);
        System.out.println();


        /*
        Normalize the names
        Clean the names to:
        Trim spaces
        Capitalize first letter, rest lowercase
         */
        List<String> names = List.of("  john ", "  aLIce", "ROBERt  ");
        names.stream().map(name -> {
            name = name.trim();
            return name.isEmpty() ? name : name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
        }).forEach(System.out::println);
        System.out.println();

        /*
        Normalize the names
        Capitalize the Strings first letter, and first letter after space
         */
        List<String> phrases = List.of("hello world developer", "java stream", "flat map");
        phrases.stream().map(name -> {
            String[] words = name.split(" ");
            name = Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase())
                    .collect(Collectors.joining(" "));
            return name;
        }).forEach(System.out::println);
        System.out.println();

        /*
        Convert List of Sentences to Word Counts
         */
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are awesome",
                "Functional programming rocks"
        );
        sentences.stream().
                map(sentence -> (int) sentence.split(" ").length)
                .forEach(System.out::println);
        System.out.println();

        /*
         Email Generator
         Convert each name to a lowercase email in the format: firstname.lastname@example.com
         */
        List<String> emailNames = List.of("John Doe", "Alice Smith", "Prashanth Reddy");
        emailNames.stream().map(name -> {
            String[] parts = name.trim().toLowerCase().split("\\s+");
            return parts[0]+"."+parts[1]+"@example.com";
        }).forEach(System.out::println);


    }
}
