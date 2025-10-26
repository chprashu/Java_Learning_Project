package learn.DSA.LearnArrays;

import java.util.*;
import java.util.stream.IntStream;

public class BasicArrayProblems {

    public static void findMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Min:" + min + " and Max:" + max);
    }

    public static long sum(int[] arr) {
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    public static void findAvg(int[] arr) {
        double s = arr.length > 0 ? sum(arr) / arr.length : 0;
        System.out.println("Average:" + s);
    }

    public static void findTargetIndex(int target, int[] arr) {
        // linear search method
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void reverseOfArray(int[] arr){
        //time complexity O(n/2)
        int n = arr.length;
        for(int i = 0; i < n / 2; i++){
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseOfArrayWithStartAndEnd(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void rotateArrayByKthPosition(int[] arr, int k){
        //1st logic using reverse from kth element
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        reverseOfArrayWithStartAndEnd(arr1, 0, arr1.length - 1);
        reverseOfArrayWithStartAndEnd(arr1, 0, k - 1);
        reverseOfArrayWithStartAndEnd(arr1, k, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));

        //2nd logic using System.arraCopy()
        int[] res = new int[arr.length];
        System.arraycopy(arr, arr.length - k, res, 0, k);
        System.arraycopy(arr, 0, res, k, arr.length - k);
        System.out.println(Arrays.toString(res));

    }

    public static void removeDuplicates(int[] arr){
        int n = arr.length;
        int[] res1 = new int[n];
        int[] res2 = new int[n];

        //1st logic using streams
        res1 = Arrays.stream(arr).distinct().toArray();

        //2nd logic using set with insertion order
        Set<Integer> set = new LinkedHashSet<>();
        for(int i: arr) set.add(i);
        System.out.println(set);

    }

    public static void mergeArraysWithoutDuplicates(int[] arr1, int[] arr2){
        int[] merged = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(merged));

        //2nd logic
        int[] res2 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, res2, 0, arr1.length);
        System.arraycopy(arr2, 0, res2, arr1.length, arr2.length);

        Set<Integer> set = new LinkedHashSet<>();
        for(int i: res2) set.add(i);
        System.out.println(set);
    }

    public static void moveAllZerosToEnd(int[] arr){
        int index = 0;
        for(int i : arr)
            if(i != 0) arr[index++] = i;

        while (index < arr.length) arr[index++] = 0;

        System.out.println(Arrays.toString(arr));
    }

    public static void findSecondLargestNumber(int[] arr){
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for(int i : arr){
            if(i >  first){
                second = first;
                first = i;
            }else if(i > second && i != first){
                second = i;
            }
        }

        System.out.println(second);
    }

    public static boolean checkArraysEqual(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length) return false;

        int count = 0;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                break;
            }else{
                count++;
            }
        }

        return arr1.length == count;
    }

    public static void countFrequencyOfElement(int[] arr){
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> frequency1 = new HashMap<>();
        for(int i: arr){
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        Arrays.stream(arr).forEach(i -> frequency1.put(i, frequency1.getOrDefault(i, 0) + 1));

        System.out.println(frequency);
        System.out.println(frequency1);
    }



    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 4, 7, 6, 10, 2, 5, 8, 2, 0 };

        findMinMax(arr);
        findAvg(arr);
        reverseOfArray(arr);
        removeDuplicates(arr);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 5, 6};
        mergeArraysWithoutDuplicates(arr1, arr2);

        int[] zerosArray = {1, 0, 12, 3, 0, 4, 5};
        moveAllZerosToEnd(zerosArray);


        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArrayByKthPosition(arr3, 3);

        int[] arr4 = {10, 20, 15, 5, 99, 30};
        findSecondLargestNumber(arr4);

        int[] a = {1, 2, 3};
        int[] b = {1, 3, 3};
        System.out.println(checkArraysEqual(a, b));

        int[] arr5 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5};
        countFrequencyOfElement(arr5);


    }
}
