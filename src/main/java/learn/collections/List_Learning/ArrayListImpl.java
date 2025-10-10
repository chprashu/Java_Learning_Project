package learn.collections.List_Learning;

import java.util.ArrayList;
import java.util.List;

public class ArrayListImpl {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.add(1));
        System.out.println(list.add(1)); // true, allows duplicate element
        System.out.println(list.add(3)); // true
        try {
            System.out.println(list.get(4));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: IndexOutOfBoundException, " + e.getLocalizedMessage());
        }
        System.out.println(list.get(2)); // get(), accepts index as argument
        System.out.println(list.size()); // to check list size

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        /*
         * this is possible because List extends Iterator indeirectly through
         * collection.
         */
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        /*
         * to remove element from List
         * return removing element
         */
        System.out.println(list.remove(2));
    }
}
