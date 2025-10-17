package learn.collections.List_Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListImpl {

    /*
     * Internal working of ArrayList.
     * Unlike in regular array, which has fixed size,
     * an ArrayList can grow and shrink as elements added
     * or removed.
     * Dynamic resizing is achieved by creating a new array
     * when current array is full and copying all elements
     * to the new array.
     * ArrayList initial capacity 10.
     * 
     * Time complexity of different operations in ArrayList
     * get element by index: O(1), because we already know the index of the element
     * adding element: O(n) copying elements to new array
     * removing element: O(n) shifting elements
     * iterating list: O(n) looping with size
     */

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        /*
         * adding elements to the ArrayList
         * 1. check capacity with current array
         * 2. Resize if necessary (1.5 times)
         * 3. Add the element
         * 
         * Resizing the Array
         * 1. initial capacity 10, array size will be 10 initially
         * 2. growth factor, a new array will create with size of 1.5 times the old
         * array
         * 3. copying elements, when resizing occurs all elements of old array moved to
         * new array
         * with time complexity of O(n)
         */
        System.out.println(list.add(1));
        System.out.println(list.add(1)); // true, allows duplicate element
        System.out.println(list.add(3)); // true

        /*
         * add() stores element in the lastIndex.
         * To store element to an specific index
         * use add(index, element);
         */
        list.add(1, 2);

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
         *
         * Removing element
         * Check Bounds: given index is within the range or not
         * Remove the Element: once removed right elements of the removed
         * element shift one position left
         * Reduce Size: size will be decremented by 1
         */
        System.out.println(list.remove(2));

        /*
         * if we already know size of elements, which needs to be add in List
         * we can set the initialCapacity to required capacity which reduces
         * adding and removing functionality of arrayList
         */
        ArrayList<Integer> list1 = new ArrayList<>(5);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1); // till here it was storing elements in array which is created with
                      // initialCapacity 5
        list1.add(1); // here list growing started

        /*
         * initial = 5 extraAdded = 1 currentCapacity = 1.5 times 5 = 8
         * size = 6, currentCapacity = 8 extra = 2
         * trimToSize() helps to reduce the capacity to size.
         */
        list1.trimToSize();

        List<String> list3 = new ArrayList<>();
        System.out.println(list3.getClass().getName()); // java.util.ArrayList
        list3.add("fruit");

        /*
         * asList creates a nested class with a fixed in size
         * so we can't add elements to it. but we can
         * replace any existing element.
         */
        List<String> list4 = Arrays.asList("hello", "hi");
        System.out.println(list4.getClass().getName()); // java.util.Arrays$ArrayList
        try {
            list4.add("bye"); // this line give exception UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        list4.set(0, "bye");
        System.out.println("list4 className" + list4);
        /*
         * to make list4 which is created by asList() (AbstractList)
         * create a new ArrayList(list4)
         */
        List<String> modifiableList4 = new ArrayList<>(list4);
        System.out.println("modifiableList4 className: " + modifiableList4.getClass().getName());

        List<Integer> list5 = List.of(1, 2, 3, 4);
        System.out.println("list5 className: " + list5.getClass().getName()); // ImmutableCollections$ListN
        try {
            list5.add(6);
            list5.set(0, 5);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            ;
        }
        /*
         * to make list5 which is created by List.of() (ImmutableCollectionList) mutable
         * create a new ArrayList(list5)
         */
        List<Integer> mutableList5 = new ArrayList<>(list5);
        System.out.println("mutableList5 className: " + mutableList5.getClass().getName());

    }
}
