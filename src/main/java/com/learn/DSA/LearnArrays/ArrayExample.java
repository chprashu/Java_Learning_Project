package com.learn.DSA.LearnArrays;

public class ArrayExample {

    /**
     * Real-world analogy:
     * Imagine an Excel sheet row where each cell stores a number. You're asked to:
     * Find duplicates
     * Remove 0s
     * Reverse the row
     * Move negatives to one side
     */

    /**
     * question 1: Reverse an Array
     */
    public void reverseArray1(int[] array) {
        /** O(logn) logic */
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public void reverseArray2(int[] array) {
        /** O(logn) logic */
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        example.reverseArray1(arr);
        System.out.println();
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        example.reverseArray2(arr2);
    }
}
