package com.learn.java8.LearnFunInterfaces.FunctionExample;

import java.util.function.Function;

public class FunctionDefaultMethodImpl {

    /**
     * Function Default methods are like this
     * 
     * andThen
     * compose
     */

    public static void implAndThen(String str) {
        Function<String, String> f1 = s -> s.toUpperCase();
        Function<String, String> f2 = s -> s.substring(0, s.length() - 1);
        Function<String, String> finalRes = f1.andThen(f2);

        System.out.println("Hello " + finalRes.apply(str));
    }

    private static void implCompose(String str) {
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        Function<Integer, Double> f2 = i -> (Double) Math.sqrt(i);

        Function<String, Double> finalRes = f2.compose(f1);

        System.out.println(finalRes.apply(str));
    }

    public static void main(String[] args) {
        implAndThen("Harish");
        implCompose("10");
    }
}
