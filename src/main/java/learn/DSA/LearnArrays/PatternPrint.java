package learn.DSA.LearnArrays;

public class PatternPrint {

    public static void printDiamond(int size) {
        int c = size * 2 - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < c; j++) {
                if (j >= size - i - 1 && j <= size + i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                if (j >= size - i - 1 && j <= size + i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDiamond(3);
    }
}
