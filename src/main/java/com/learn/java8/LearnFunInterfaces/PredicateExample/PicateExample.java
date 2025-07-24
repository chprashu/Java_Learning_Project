package com.learn.java8.LearnFunInterfaces.PredicateExample;

import java.util.function.Predicate;

import com.learn.java8.TestModals.Employee;

class PredicateExample {
    /*
     * Predicate return Boolean Value
     * except Type t argument
     */
    public static void main(String[] args) {
        /* old way to implement Predicate */
        Predicate<String> strPre = new Predicate<String>() {

            @Override
            public boolean test(String t) {
                return t.isEmpty();
            }

        };

        System.out.println(strPre.test(""));
        System.out.println(strPre.test("java"));
        System.out.println("old method ended here.... \n");

        /* Sightly Modified way of Predicate implementation */
        Predicate<String> str1Pre = String::isEmpty;
        System.out.println(str1Pre.test(""));
        System.out.println(str1Pre.test("Java"));
        System.out.println("slightly modified method ended here.... \n");

        /* Efficient way of implementing Predicate */
        System.out.println(((Predicate<String>) String::isEmpty).test(""));
        System.out.println(((Predicate<String>) String::isEmpty).test("java"));
        System.out.println("efficient way  ended here.... \n");

        /* Predicate Default Methods */
        Predicate<Employee> emp = (employee) -> employee.name.equals("Harish");
        Predicate<Employee> emp1 = (employee) -> employee.department.equals("It");
        Predicate<Employee> res = emp.and(emp1);
        System.out.println(res.test(new Employee()));
        ;

    }
}
