package learn.DSA.twoDArray;

public class rotateMatrx {

    private static void rotateMatrix(int r, int c, int[][] matrix) {

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int row = 4, col = 4;

        int[][] array = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        rotateMatrix(row, col, array);

    }
}
