package com.learn.java8.LearnStreamAPI.IntermediateOpsMethods;

import java.util.Comparator;
import java.util.List;

public class SortedMethodExample {
    /**
     * sorting() is using to sort the stream
     * return type of sorted()
     * Stream<T>
     */

    public static void main(String[] args) {

        /*
         * problem 1: sort in Natural order
         */
        List<Integer> numbers = List.of(5, 2, 9, 1);
        List<Integer> naturalOrder = numbers.stream().sorted().toList();
        System.out.println(naturalOrder);
        System.out.println();

        /*
         * problem 2: sort in reverseOrder
         */
        List<Integer> reverseOrder = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(reverseOrder);
        System.out.println();

        /*
         * problem 3: Custom sort by field
         */
        record Person(String name, int age) {
        }

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 22),
                new Person("Charlie", 25));
        List<Person> ageSort = people.stream().sorted(Comparator.comparing(Person::age)).toList();
        System.out.println(ageSort);
        System.out.println();

        List<Person> nameSort = people.stream().sorted(Comparator.comparing(Person::name).reversed()).toList();
        System.out.println(nameSort);
        System.out.println();

        /*
         * Problem 4: Sort by name length, then alphabetically:
         */
        List<String> names = List.of("Zebra", "Bear", "Elephant", "Dog");
        names = names.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .toList();
        System.out.println(names);
    }
}
