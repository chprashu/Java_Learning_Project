package learn.java8.LearnFunInterfaces.ConsumerExamples;

import java.util.function.Consumer;

public class ConsumerExample {
    /***
     * Consumer returns nothing
     * it is basically used for
     * logging
     * printing
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
    }
}
