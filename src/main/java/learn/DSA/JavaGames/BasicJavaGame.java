package learn.DSA.JavaGames;

import java.util.Random;
import java.util.Scanner;

public class BasicJavaGame {

    private static final Scanner sc = new Scanner(System.in);

    public static void numberGuessingGame() {
        int num = new Random().nextInt(100);

        while (true) {
            int userInt = sc.nextInt();
            if (userInt == num) {
                System.out.println(userInt + " is a Correct ans...");
                break;
            } else if (userInt > num) {
                System.out.println(userInt + " is too high than random...");
            } else if (userInt < num) {
                System.out.println(userInt + " is too low than random...");
            }
        }
    }

    public static void rockPaperScissor() {
        int num = new Random().nextInt(1, 3);
        System.out.println("1 for Rock\n2 for Paper\n3 for Scissors");
        System.out.print("Please provide your Input: ");
        int input = sc.nextInt();
        if (input > 3 || input < 1) {
            while (true) {
                System.out.print("Please provide correct Input: ");
                input = sc.nextInt();
                if (input >= 1 && input <= 3) {
                    break;
                }
            }
        }

        if (num == input) {
            System.out.println("Match Darw..");
        } else if (num == 1) {
            if (input == 2) {
                System.out.println("You loss..");
            } else if (input == 3) {
                System.out.println("You win..");
            }
        } else if (num == 2) {
            if (input == 1) {
                System.out.println("You win..");
            } else if (input == 3) {
                System.out.println("You loss..");
            }
        } else if (num == 3) {
            if (input == 1) {
                System.out.println("You win..");
            } else if (input == 2) {
                System.out.println("You loss..");
            }
        }

    }

    public static void main(String[] args) {
        // numberGuessingGame();
        rockPaperScissor();
    }
}
