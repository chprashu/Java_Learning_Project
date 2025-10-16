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

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
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
    }
}
