import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Craps!");

        boolean playAgain = true;

        while (playAgain) {
            playCraps();
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }

        System.out.println("Thanks for playing Craps!");
        scanner.close();
    }

    public static void playCraps() {
        int point = 0;
        boolean gameEnd = false;

        while (!gameEnd) {
            int sum = rollDice();
            if (point == 0) { // First roll
                if (sum == 2 || sum == 3 || sum == 12) {
                    System.out.println("You rolled " + sum + ". Craps! You lose.");
                    gameEnd = true;
                } else if (sum == 7 || sum == 11) {
                    System.out.println("You rolled " + sum + ". Natural! You win.");
                    gameEnd = true;
                } else {
                    point = sum;
                    System.out.println("You rolled " + sum + ". Point is now " + point);
                }
            } else { // Subsequent rolls
                if (sum == point) {
                    System.out.println("You rolled " + sum + ". Made point! You win.");
                    gameEnd = true;
                } else if (sum == 7) {
                    System.out.println("You rolled " + sum + ". Seven out! You lose.");
                    gameEnd = true;
                } else {
                    System.out.println("You rolled " + sum + ". Trying for point " + point);
                }
            }
        }
    }

    public static int rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Rolling the dice... Die 1: " + die1 + ", Die 2: " + die2 + ". Sum: " + sum);
        return sum;
    }
}