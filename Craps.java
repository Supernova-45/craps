import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("LET'S PLAY CRAPS!");
        System.out.println("Do you need instructions (y/n)?");
        if (in.nextLine().equals("") || in.nextLine().substring(0,1).equalsIgnoreCase("y")) {
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

        int firstRoll;
        boolean playing = true;
        boolean notOver = true;

        while (playing == true) {

            // first roll
            System.out.print("Press <Enter> to roll...");
            String pause = in.nextLine();
            firstRoll = roll();
            System.out.println("Your first roll is: " + firstRoll);
            System.out.println("That's your point.");
            if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("You win! Want to play again? (y/n)");
                if (in.nextLine().equals("") || in.nextLine().substring(0,1).equalsIgnoreCase("n")) {
                    playing = false;
                }
            } else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.println("You lost, sorry. Want to play again? (y/n)");
                if (in.nextLine().equals("") || in.nextLine().substring(0,1).equalsIgnoreCase("n")) {
                    playing = false;
                }
            } else {
                System.out.println("Let's see if you can roll it again before you roll a 7!");
                notOver = true;
                while (notOver = true) {

                }
            }
        }   
        /**
         * while the user wants to keep playing
         * 
         * roll the 2 die, save the value
         * if it's a 7 or 11: autowin, play over
         * if it's a 2,3,12: autolose, play over
         * (can probably get a boolean method to streamline)
         * 
         * now you need another while loop for the game
         * if the roll is the same as the first, that's a win
         * a 7 is a loss
         * 
         */

        in.close();
    }

    public static int roll() {
        Die rollOne = new Die();
        Die rollTwo = new Die();
        return rollOne.getRoll() + rollTwo.getRoll();
    }
}
