package learn.java8.LearnStreamAPI.IntermediateOpsMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapExample {

        /*
         * flatMap() accepts Function(functional Interface) as a argument
         * flatMap(Function<T, Stream<R>>)
         * returns
         */

        public static void main(String[] args) {

                /*
                 * Problem 1:
                 * Converting nested list to a flatlist
                 */
                List<List<String>> nested = List.of(
                                List.of("Java", "Python"),
                                List.of("C++", "Go"),
                                List.of("Kotlin"));
                List<String> flatList = nested.stream().flatMap(List::stream).toList();
                System.out.println(flatList);
                System.out.println();

                /*
                 * Problem 2:
                 * Convert list of sentences to List of words
                 */
                List<String> sentences = List.of("Java is cool", "Streams are powerful");
                List<String> words = sentences.stream().flatMap(sent -> Arrays.stream(sent.split("\\s+"))).toList();
                System.out.println(words);
                System.out.println();

                /*
                 * Problem 3:
                 * extract all the emails from all the users
                 * Extract a list of unique email domains
                 */
                List<User> users = List.of(
                                new User("Alice", List.of("alice@gmail.com", "alice@work.org")),
                                new User("Bob", List.of("bob@yahoo.com")),
                                new User("Charlie", List.of("charlie@gmail.com", "charlie@home.io")));
                List<String> emails = users.stream().flatMap(user -> user.getEmails().stream())
                                // .sorted((s1, s2) -> s1.split("@")[1].compareTo(s2.split("@")[1]))
                                // .map(email -> email.split("@")[1])
                                .map(email -> email.substring(email.indexOf("@") + 1, email.length()))
                                .sorted()
                                .toList();
                System.out.println(emails);
                System.out.println();

                /*
                 * Problem 4: Group Users by Email Domain
                 * Group the users by email domain, showing which users have addresses in which
                 * domains.
                 */
                List<User> users1 = List.of(
                                new User("Alice", List.of("alice@gmail.com", "alice@work.org")),
                                new User("Bob", List.of("bob@yahoo.com")),
                                new User("Charlie", List.of("charlie@gmail.com", "charlie@home.io")),
                                new User("Dave", List.of("dave@gmail.com", "dave@work.org")));
                Map<String, List<String>> collect = users1.stream().flatMap(user -> user.getEmails().stream()
                                .map(email -> Map.entry(email.split("@")[1], user.getName())))
                                // .forEach(System.out::println);
                                .collect(Collectors.groupingBy(Map.Entry::getKey,
                                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
                System.out.println(collect);
                System.out.println();

                /*
                 * Count number of users per domain?
                 */
                Map<String, Long> collect1 = users1.stream().flatMap(user -> user.getEmails().stream()
                                .map(email -> Map.entry(email.split("@")[1], user.getName())))
                                .collect(Collectors.groupingBy(Map.Entry::getKey,
                                                Collectors.mapping(Map.Entry::getValue, Collectors.counting())));
                System.out.println(collect1);
                System.out.println();

                /*
                 * Find the domain with the most users?
                 */
                users1.stream().flatMap(user -> user.getEmails().stream()
                                .map(email -> Map.entry(email.split("@")[1], user.getName())))
                                .collect(Collectors.groupingBy(Map.Entry::getKey,
                                                Collectors.mapping(Map.Entry::getValue, Collectors.counting())));

        }
}

class User {
        String name;
        List<String> emails;

        User(String name, List<String> emails) {
                this.name = name;
                this.emails = emails;
        }

        public String getName() {
                return name;
        }

        public List<String> getEmails() {
                return emails;
        }
}
