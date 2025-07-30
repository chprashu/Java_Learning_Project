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
         * Using map print square root of all numbers
         */
        numbers.stream().map(Math::sqrt).forEach(System.out::println);
        System.out.println();

        /*
         * Convert a list of full names ("John Doe") into just first names.
         */
        List<String> fullNames = List.of("Jhon Cina", "Mary Kom", "Randy Otan", "Jhon Doe", "Jhony Deff", "Elon Musk");
        fullNames.stream().map(str -> str.split(" ")[0]).forEach(System.out::println);
        System.out.println();

        /*
         * Transform a list of strings into a list of their character counts.
         */
        fullNames.stream().map(name -> (int) name.chars().filter(Character::isLetter).count())
                .forEach(System.out::println);
        System.out.println();

        /*
         * Convert a list of strings into a list of Optional<String>.
         */
        fullNames.stream().map(Optional::of).forEach(System.out::println);
        System.out.println();

        /*
         * Normalize the names
         * Clean the names to:
         * Trim spaces
         * Capitalize first letter, rest lowercase
         */
        List<String> names = List.of("  john ", "  aLIce", "ROBERt  ");
        names.stream().map(name -> {
            name = name.trim();
            return name.isEmpty() ? name
                    : name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
        }).forEach(System.out::println);
        System.out.println();

        /*
         * Normalize the names
         * Capitalize the Strings first letter, and first letter after space
         */
        List<String> phrases = List.of("hello world developer", "java stream", "flat map");
        phrases.stream().map(name -> {
            String[] words = name.split(" ");
            name = Arrays.stream(words)
                    .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase())
                    .collect(Collectors.joining(" "));
            return name;
        }).forEach(System.out::println);
        System.out.println();

        /*
         * Convert List of Sentences to Word Counts
         */
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are awesome",
                "Functional programming rocks");
        sentences.stream().map(sentence -> (int) sentence.split(" ").length)
                .forEach(System.out::println);
        System.out.println();

        /*
         * Email Generator
         * Convert each name to a lowercase email in the format:
         * firstname.lastname@example.com
         */
        List<String> emailNames = List.of("John Doe", "Alice Smith", "Prashanth Reddy");
        emailNames.stream().map(name -> {
            String[] parts = name.trim().toLowerCase().split("\\s+");
            return parts[0] + "." + parts[1] + "@example.com";
        }).forEach(System.out::println);
        System.out.println();

        /*
         * Masking Sensitive IP Addresses
         * You're given a list of IP addresses (IPv4) as List<String>. Some of these IPs
         * belong to internal systems and need to be masked for logging purposes.
         * Write a Java method that:
         * Accepts a list of IP addresses.
         * Masks each IP address by replacing the last octet with "***" (e.g.,
         * "192.168.0.100" becomes "192.168.0.***").
         * Returns a new List<String> of the masked IPs using the Stream API and map()
         * function.
         */
        List<String> ips = Arrays.asList(
                "192.168.0.100",
                "10.0.0.1",
                "172.16.254.5",
                "invalid.ip.address");

        ips.stream().map(ip -> {
            String[] parts = ip.split("\\.");
            if (parts.length == 4) {
                parts[3] = "***";
            }
            return String.join(".", parts);
        }).forEach(System.out::println);
        System.out.println();

        /*
         * Check Validity of IP Addresses Using
         * You are given a list of IP addresses (IPv4), represented as a List<String>.
         * Write a Java method that:
         * Uses the Stream API with map() to transform each IP into true or false.
         * 
         * IP Validation Rules:
         * An IP address is valid if:
         * It contains exactly 4 parts separated by ".".
         * Each part is an integer between 0 and 255.
         * No leading zeros unless the number is 0 (e.g., "01" is invalid, but "0" is
         * valid).
         */
        List<String> tempIps = Arrays.asList(
                "192.168.1.1",
                "255.255.255.255",
                "256.100.50.25",
                "123.045.067.089",
                "10.0.0",
                "1.2.3.4.5",
                "abc.def.ghi.jkl",
                "0.0.0.0",
                "01.2.3.4");

        tempIps.stream().map(ip -> {
            String[] parts = ip.split("\\.");
            if (parts.length < 4)
                return false;
            for (String part : parts) {
                if (!part.matches("\\d+"))
                    return false;
                if (part.length() > 1 && part.startsWith("0"))
                    return false;
                if (Integer.parseInt(part) > 255 || Integer.parseInt(part) < 0)
                    return false;
            }
            return true;
        }).forEach(System.out::println);

        /*
         * Anagram Signature
         * For each word, return its sorted character string
         */
        List<String> words = List.of("listen", "silent", "enlist", "google", "gooleg");
        words.stream().map(word -> {
            word = word.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
            return word;
        }).forEach(System.out::println);
        System.out.println();
    }
}
