package com.learn.DSA.LearnArrays;

import java.util.Arrays;

public class ArrayExample {

    /**
     * Real-world analogy:
     * Imagine an Excel sheet row where each cell stores a number. You're asked to:
     * Find duplicates
     * Remove 0s
     * Reverse the row
     * Move negatives to one side
     */

    public <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * problem 1: Reverse an Array
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

    /*
     * Problem 2: In-place removal of element k
     */
    public int[] inPlaceRemoval(int[] array, int k) {
        /** O(n) logic */
        int write = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != k) {
                array[write++] = array[i];
            }
        }

        return array;
    }

    /*
     * problem 3: Apply Operations to an Array
     */
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        int[] array = new int[nums.length];
        int write = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                array[write++] = nums[i];
            }
        }

        return array;

    }

    /*
     * problem 4: Sum of Distances
     */
    public Integer[] distance(Integer[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[i] == nums[j]) {
                    if (i > j) {
                        sum += i - j;
                    } else {
                        sum += j - i;
                    }
                }
            }
            if (sum == 0) {
                arr[i] = 0;
            } else {
                arr[i] = sum;
            }
        }

        return arr;
    }

    /*
     * Pro
     */

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();

        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // example.reverseArray1(arr);
        // System.out.println();
        // int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // example.reverseArray2(arr2);

        // int[] inPlaceRemovalArray = { 1, 2, 3, 5, 3, 6, 2, 3 };
        // example.inPlaceRemoval(inPlaceRemovalArray, 3);

        // int[] nums = { 847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272
        // };
        // example.printArray(example.applyOperations(nums));

        Integer[] nums = { 1, 3, 1, 1, 2 };
        example.printArray(example.distance(nums));
    }
}
