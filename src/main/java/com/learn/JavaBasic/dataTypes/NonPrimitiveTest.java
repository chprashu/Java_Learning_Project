package com.learn.JavaBasic.dataTypes;

public class NonPrimitiveTest {
    public static void main(String[] args) {
        /*
         * Non-primitive data types (also known as reference types) in Java include:
         * Strings, Arrays, Classes, Interfaces, enum types
         * Non-primitive data types are stored in heap memory
         * they hold references (memory addresses) to the actual data
         * eg: String str = "Hello";
         * str holds the reference to the memory location where "Hello" is stored
         * 
         * The main difference between primitive and non-primitive data types is that
         * non-primitive data types can hold multiple values and have methods
         * eg: String is a non-primitive data type that can hold a sequence of
         * characters.
         */

        String str = "Hello, World!"; // String is a non-primitive data type
        System.out.println(str); // prints the actual string value since String class overrides toString() method
                                 // to return the string value.

        int[] arr = { 1, 2, 3, 4, 5 }; // Array is a non-primitive data type
        System.out.println(arr); // prints the reference (memory address) to the array, not the actual values
    }
}
