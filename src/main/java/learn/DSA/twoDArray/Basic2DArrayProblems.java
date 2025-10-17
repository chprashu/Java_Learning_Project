package learn.DSA.twoDArray;

public class Basic2DArrayProblems {

    private static void printDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printReverseDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + j == array.length - 1) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void transPondArray(int[][] arr) {
        int r = arr.length, c = arr[0].length;

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void findMaxium(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);
    }

    public static void printBoundryElements(int[][] arr) {
        int r = arr.length, c = arr[0].length;
        // print 1st row left to right
        for (int i = 0; i < c; i++) {
            System.out.print(arr[0][i] + " ");
        }

        // print last column top to bottom
        for (int j = 1; j < r; j++) {
            System.out.print(arr[j][c - 1] + " ");
        }

        // print last row right to left
        if (r > 1) {
            for (int i = c - 2; i >= 0; i--) {
                System.out.print(arr[r - 1][i] + " ");
            }
        }

        // print first column bottom to top
        if (r > 1) {
            for (int j = r - 2; j > 0; j--) {
                System.out.print(arr[j][0] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        printDiagonal(arr);
        System.out.println();
        printReverseDiagonal(arr);
        System.out.println();
        int[][] arr2 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        transPondArray(arr2);
        System.out.println();
        findMaxium(arr);
        System.out.println();
        int[][] arr3 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        printBoundryElements(arr3);
        System.out.println();
    }
}
