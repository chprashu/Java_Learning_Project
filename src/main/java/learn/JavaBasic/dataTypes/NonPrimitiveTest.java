package learn.JavaBasic.dataTypes;

import java.util.Arrays;

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
        /*
         * String will have some same properties like primitive data types,
         * eg: default value is null
         * String is immutable (cannot be changed once created)
         * through pass-by-value we can't change the original string value in a method
         * but we can change the reference to point to a new string
         */
        System.out.println("Before modification: " + str);
        modifyString(str);
        System.out.println("After modification: " + str); // original string remains unchanged

        int[] arr = { 1, 2, 3, 4, 5 }; // Array is a non-primitive data type
        System.out.println("Before Modification: " + Arrays.toString(arr)); // prints the actual array values
        modifyArray(arr);
        System.out.println("After Modification: " + Arrays.toString(arr)); // original array is modified since arrays
                                                                           // are mutable

        System.out.println("Before changing array reference: " + arr + " values:" + Arrays.toString(arr));
        /*
         * If we modify the reference of the array inside the method,
         * it will not affect the original array reference outside the method.
         * because we are changing the reference to point to a new array
         * since a copy of the reference is passed to the method
         */
        modifyArrayReference(arr);
        System.out.println("After changing array reference: " + arr + " values:" + Arrays.toString(arr));

    }

    public static void modifyString(String s) {
        s = "Goodbye, World!"; // this change will not affect the original string since strings are immutable
    }

    public static void modifyArray(int[] array) {
        array[0] = 99; // this change will affect the original array since arrays are mutable
    }

    public static void modifyArrayReference(int[] array) {
        array = new int[] { 10, 20, 30 }; // this change will not affect the original array reference
    }
}
