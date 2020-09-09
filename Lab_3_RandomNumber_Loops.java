/*
Sam Donnermeyer
CSCI 152 Fall 2020
Lab #3 Random Number & Loops lab - 9/2/2020

This program will require you to generate random numbers between 1 and 6, and to do some operations within a loop. The program should:
1. Prompt the user to enter how many times he/she would like to throw the dice.
2. Accept an integer n
3. Throw two dice n times. Use a random number generator (import java.lang.Math.Random – see
the link on Moodle) to generate the values of the dice.
4. Output the values of each throw on a separate line. Use printf to format your output. Make the
output clear and easy to understand for the user.
5. If the throw is a pair, include that in the output.
6. Print one blank line, and then output an average of the values of all the dice.
 */

import java.util.Scanner;
import java.lang.Math;

public class Lab_3_RandomNumber_Loops {
    public static void main(String[] args) {
        // Initialize Scanner Object
        Scanner scanner_obj = new Scanner(System.in);

        // Intro for user
        System.out.println("Welcome to the world-class dice roller!");
        System.out.println("---------------------------------------");

        // Accept an integer
        System.out.println("Please enter a number of times the dice to be rolled.");
        int user_int = scanner_obj.nextInt();

        int total_roll = 0;
        // Roll the dice
        for (int i = 0; i < user_int; i++) {
            // Roll the dice
            int die1 = (int) (Math.random()*6) + 1;
            int die2 = (int) (Math.random()*6) + 1;

            if (die1 == die2) {
                System.out.printf("%d %d - You threw a pair!\n", die1, die2);
            } else {
                System.out.printf("%d %d\n", die1, die2);
            }

            // Add roll to total roll count
            total_roll += (die1 + die2);
        }

        // Print Roll Average
        System.out.printf("\nThe average dice roll: %d", (total_roll/(user_int*2)));


    }


}
