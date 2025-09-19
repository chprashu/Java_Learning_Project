package learn.JavaBasic.dataTypes.String;

import learn.JavaBasic.TestModals.Student;

public class StringTest {

    public static void main(String[] args) {

        String str = "Hello, World!"; // String literal saved in String pool
        str = "ahduygweu"; // new String literal, new memory location in String pool
        int a = 10;
        String str1 = new String("Hello, World!"); // String object created in heap

        System.out.println(str == str1); // false because they reference different
        // memory locations
        System.out.println(str.equals(str1)); // true because their content is the

        /*
         * Using == to compare two different strings with the same content will return
         * unless both references point to the same object in memory.
         * The intern() method returns a canonical representation for the string
         * object,
         * which means it returns a reference to the unique string from the string
         * pool
         * that has the same contents. If such a string does not exist in the pool,
         * it is added. This ensures that all equal strings share the same memory
         * reference.
         */
        System.out.println(str == str.intern()); // true because str.intern() returns
        // the reference from the String pool

        Student student = new Student();
        System.out.println(student);
        System.out.println("Before: " + str + ", Student name: " + student.name + ", a: " + a); // Hello world,
                                                                                                // prashanth, 10
        test(str, student, a);
        System.out.println("After: " + str + ", Student name: " + student.name + ", a: " + a);
        // testing, muni, 20
    }

    public static void test(String str, Student student, int a) {
        str = "testing";
        student.name = "muni";
        a = 20;
    }
}