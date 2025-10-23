package learn.DSA.LearnArrays;

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

    public static void findPairSum(int target, int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 4, 7, 6, 10, 2, 5, 8, 2, 0 };
        findMinMax(arr);
        findAvg(arr);
    }
}
