package com.learn.java8.LearnFunInterfaces.FunctionExample;

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

        System.out.println(exe1.apply("Java Development") + "\n****************\n");

        /** Slightly modified way to implement Function */
        Function<String, Integer> exe2 = String::length;
        System.out.println(exe2.apply("Java Development") + "\n****************\n");

        /** utilization of Function interface as a Parameter */
        Function<Integer, Boolean> fun1 = s -> s % 2 == 0;
        System.out.println((Integer) FunctionExample.transform("Prashanth", String::length));
        System.out.println("*****************\n");

    }

    public static <T, R> R transform(T input, Function<T, R> function) {
        return function.apply(input);
    }
}
