package learn.java8.LearnFunInterfaces.PredicateExample;

import java.util.Arrays;
import java.util.function.Predicate;

import learn.java8.TestModals.Employee;

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

        /*
         * Predicate usage in Stream API filter method
         * filter method accept Predicate as argument
         */
        System.out.println("Predicate usage in Stream API filter method ended here.... \n");
        /*
         * Checking even number using Predicate
         * Checking prime number using Predicate
         */
        Predicate<Integer> checkEven = i -> i % 2 == 0;
        Predicate<Integer> checkPrime = i -> {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    return false;
                }
            }
            return true;
        };
        int[] arr = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        System.out.print("Even Numbers are : ");
        Arrays.stream(arr).filter(checkEven::test).forEach(x -> System.out.print(x + " "));
        System.out.print("\nPrime Numbers are : ");
        Arrays.stream(arr).filter(checkPrime::test).forEach(x -> System.out.print(x + " "));
    }
}
