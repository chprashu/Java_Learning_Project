package com.learn.JavaBasic.dataTypes;

public class PremitiveTest {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        /*
         * We have 8 primitive data types in Java:
         * byte, short, int, long, float, double, char, boolean
         * primitive data types stored in stack memory
         * they hold their values directly in memory
         * they are not objects and do not have methods
         * they are faster and require less memory compared to objects
         */

        /*
         * A byte is an 8-bit signed integer data type in Java.
         * It can hold values from -128 to 127 (inclusive).
         * range: -2^7 to 2^7-1 (-128 to 127)
         * default value is 0
         */
        byte b = 10; // 1 byte, 8 bits.

        /*
         * A short is a 16-bit signed integer data type in Java.
         * It can hold values from -32,768 to 32,767 (inclusive).
         * range: -2^15 to 2^15-1 (-32,768 to 32,767)
         * default value is 0
         */
        short s = 1000; // 2 bytes, 16 bits.
        /*
         * An int is a 32-bit signed integer data type in Java.
         * It can hold values from -2,147,483,648 to 2,147,483,647 (inclusive).
         * these are not literals they are just values
         * default value is 0
         * range: -2^31 to 2^31-1 (-2,147,483,648 to 2,147,483,647)
         */
        int i = 100000; // 4 bytes, 32 bits.

        /*
         * A long is a 64-bit signed integer data type in Java.
         * It can hold values from -9,223,372,036,854,775,808 to
         * 9,223,372,036,854,775,807 (inclusive).
         * To denote a long literal, you should append an 'L' or 'l' to the number.
         * if we dont use L or l it will be treated as int by default till the value is
         * in int range.
         * default value is 0L
         * range: -2^63 to 2^63-1 (-9,223,372,036,854,775,808 to
         * 9,223,372,036,854,775,807)
         */
        long l = 100000L; // 8 bytes, 64 bits

        /*
         * A float is a single-precision 32-bit IEEE 754 floating point data type in
         * Java.
         * It can hold decimal values with a precision of about 7 decimal digits.
         * To denote a float literal, you should append an 'F' or 'f' to the number.
         * if we dont use f or F it will be treated as double by default
         * default value is 0.0f
         * range: approximately ±1.40239846E-45 to ±3.40282347E+38 (6-7 significant
         * decimal digits).
         */
        float f = 10.5f; // 4 bytes, 32 bits.

        /*
         * A double is a double-precision 64-bit IEEE 754 floating point data type in
         * Java.
         * It can hold decimal values with a precision of about 15-16 decimal digits.
         * By default, decimal numbers are treated as double literals.
         * default value is 0.0d
         * range: approximately ±4.94065645841246544E-324 to ±1.79769313486231570E+308
         * (15-16 significant decimal digits).
         */
        double d = 20.99; // 8 bytes, 64 bits.

        /*
         * A char is a single 16-bit Unicode character data type in Java.
         * It can hold a single character, such as a letter, digit, or symbol.
         * Char literals are enclosed in single quotes (' ').
         * default value is '\u0000' (null character)
         * range: '\u0000' (0) to '\uffff' (65,535)
         */
        char c = 'A'; // 2 bytes, 16 bits.

        /*
         * A boolean is a data type in Java that can hold one of two values: true or
         * false.
         * It is used to represent logical values and is commonly used in conditional
         * statements and loops.
         * default value is false
         */
        boolean bool = true; // 1 bit, 1 byte (but JVM optimizes it)

        /*
         * primitive data types are immutable, they are passed by value.
         * eg: when we pass a primitive data type to a method, a copy of the value is
         * made.
         * any changes made to the parameter inside the method do not affect the
         * original value.
         * why because they are stored in stack memory.
         */
        int num = 10;
        System.out.println("Before: " + num); // 10
        test(num);
        System.out.println("After: " + num); // 10
    }

    public static void test(int num) {
        num = 20; // this change will not affect the original value
    }
}
