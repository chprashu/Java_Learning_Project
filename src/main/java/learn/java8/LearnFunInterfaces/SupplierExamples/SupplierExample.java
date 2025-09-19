package learn.java8.LearnFunInterfaces.SupplierExamples;

import java.util.function.Supplier;

public class SupplierExample {

    /**
     * Supplier returns the type you mentioned
     * it doesn't accept any arguments
     * 
     * usecases are
     * common otp generation, etc
     */

    public static void main(String[] args) {

        Supplier<String> s1 = () -> "Hello welcome to java8";
        Supplier<Integer> otp = () -> (int) Math.random() * 10000;
        System.out.println(s1.get());
        System.out.println(otp.get());
    }
}
