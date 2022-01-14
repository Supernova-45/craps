/**
 * Replicates a game of Craps.
 * @author Alexandra Kim
 * @version 1-13-2021
 */

import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to play Craps (Y/n)?");
        String playGame = in.nextLine();
        if (playGame.equals("") || playGame.substring(0,1).equalsIgnoreCase("y")) {
            System.out.println("LET'S PLAY CRAPS!");
        }
        else if (playGame.substring(0,1).equalsIgnoreCase("n")) {
            System.out.println("Sad. Bye!");
            System.exit(0); 
        }  
        // instructions
        System.out.println("Do you need instructions (y/n)?");
        String instruct = in.nextLine();
        if (instruct.equals("") || instruct.substring(0,1).equalsIgnoreCase("y")) {
            System.out.println("1. Roll two six-sided dice.");
            System.out.println("2. a. On first roll, if you get a 7 or 11 you win!");
            System.out.println("2. b. On first roll, if you get a 2, 3, or 12 you lose!");
            System.out.println("2. c. Any other number you don't win or lose. The die roll becomes your 'point.'");
            System.out.println("3. Keep rolling the dice again until:");
            System.out.println("4. a. You roll the point again and win!");
            System.out.println("4. b. or you roll a 7 and lose.)");
        }
        System.out.println();
        System.out.println("Good luck!");

        int point; // keeps track of the user's point
        int roll;
        boolean playing = true; // whether the user wants to keep playing
        boolean notOver = true; // whether the current game is finished

        outerloop:
        while (playing == true) {
            // first roll
            System.out.print("Press <Enter> to roll...");
            String pause = in.nextLine();
            point = roll();
            System.out.println("Your first roll is: " + point);
            System.out.println("That's your point.");
            if (point == 7 || point == 11) { // autowin
                System.out.println("You win! Want to play again? (y/n)");
                String playAgain = in.nextLine();
                if (playAgain.equals("") || playAgain.substring(0,1).equalsIgnoreCase("n")) {
                    playing = false;
                }
            } else if (point == 2 || point == 3 || point == 12) { // autolose
                System.out.println("You lost, sorry. Want to play again? (y/n)");
                String playAgain = in.nextLine();
                if (playAgain.equals("") || playAgain.substring(0,1).equalsIgnoreCase("n")) {
                    playing = false;
                }
            } else { // keep rolling
                System.out.println("Let's see if you can roll it again before you roll a 7!");
                notOver = true;
                innerloop:
                while (notOver = true) {
                    // roll
                    System.out.print("Press <Enter> to roll...");
                    pause = in.nextLine();
                    roll = roll();
                    System.out.println("You rolled: " + roll);
                    if (roll == 7) { // autoloss
                        System.out.println("You lose. Want to play again? (y/n)");
                        String playAgain = in.nextLine();
                        if (playAgain.equals("") || playAgain.substring(0,1).equalsIgnoreCase("n")) {
                            playing = false;
                            notOver = false;
                        }
                        notOver = false;
                        break innerloop;
                    } else if (roll == point) { // the only way to win
                        System.out.println("You rolled your point! You win! Want to play again? (y/n)");
                        String playAgain = in.nextLine();
                        if (playAgain.equals("") || playAgain.substring(0,1).equalsIgnoreCase("n")) {
                            playing = false;
                        }
                        notOver = false;
                        break innerloop;
                    } else {
                        System.out.println("Keep rolling...");
                    }
                }
            }
        }   
        System.out.println("Thanks for playing.");

        in.close();
    }

    /**
     * Rolls two Die
     * @return the sum of two die
     */

    public static int roll() {
        Die rollOne = new Die();
        Die rollTwo = new Die();
        return rollOne.getRoll() + rollTwo.getRoll();
    }
}
