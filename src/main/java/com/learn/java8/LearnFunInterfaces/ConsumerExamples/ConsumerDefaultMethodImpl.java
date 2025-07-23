package com.learn.java8.LearnFunInterfaces.ConsumerExamples;

import java.util.function.Consumer;

public class ConsumerDefaultMethodImpl {

    /***
     * Consumer Default Methods are
     * andThen
     */

    private static void implAndThen() {
        Consumer<String> c1 = s -> System.out.println("Hello " + s);
        Consumer<String> c2 = s -> System.out.println("Email sent successfully " + s);

        Consumer<String> finalRes = c1.andThen(c2);
        finalRes.accept("Prashanth");

    }

    public static void main(String[] args) {

        implAndThen();
    }
}
