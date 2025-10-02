package learn.java8.LearnFunInterfaces.SupplierExamples;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SupplierExample {

    /**
     * Supplier returns a value of the specified type.
     * It does not accept any arguments.
     * 
     * Use cases include:
     * - OTP generation
     * - Lazy value initialization
     * - Supplying values in Streams
     */

    public static void main(String[] args) {

        Supplier<String> s1 = () -> "Hello welcome to java8";
        Supplier<Integer> otp = () -> (int) ThreadLocalRandom.current().nextDouble() * 10000;
        System.out.println(s1.get());
        System.out.println(otp.get());
    }
}
