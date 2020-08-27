/*
Requirements:
    -
    integers on the outside corners (4 integers)
    integers on the inside (8 integers)
    fortunes under the inside flaps (4 fortunes)
    The system of selection must resemble how 4 of the 8 choices will always be shown together.
    -
To use the fortune picker, the user will:
1. Select an integer n1 from the outside corners (the fortune picker will be moved n1 times)
2. Select an available integer n2 from the inside (the fortune picker will be moved n2 times)
3. Select an available integer n3 from the inside (the flap will be lifted and the fortune revealed)

Code Overview:
    Allow the user to select 1 - 4 (outer layer)
    Have the user make a selection based on the four numbers in the inner layer (reveled through previous step)
    Based on the last selection, display the four options of fortunes to the user.
    User Selects an option from the last four -> present fortune

 */

import java.util.Scanner;
import java.util.*;

public class Lab_2_FortunePicker {
    public static void main(String[] args) {
        // Initialize Fortune Dictionary/hashtable //
        Dictionary fortune = new Hashtable();
        // Add Items to the hashtable under number keys 1-8
        fortune.put(1, "Two things you will never have to chase: True friends and true love.");
        fortune.put(2, "A fresh start will put you on your way.");
        fortune.put(3, "A friend asks only for your time not your money.");
        fortune.put(4, "A friend is a present you give yourself.");
        fortune.put(5, "A good time to finish up old tasks.");
        fortune.put(6, "A short pencil is usually better than a long memory any day.");
        fortune.put(7, "A soft voice may be awfully persuasive.");
        fortune.put(8, "Accept something that you cannot change, and you will feel better.");

        // Initialize the even/odd groups
        // Instantiating List using Arrays.asList()
        List<Integer> even_list = Arrays.asList(1, 2, 5, 6);
        List<Integer> odd_list = Arrays.asList(3, 4, 7, 8);

        // Give explanation
        System.out.println("Fortune Picker:");

        // FIRST SELECTION //

        // Get first selection
        Scanner scan_obj_1 = new Scanner(System.in); // Create Scanner object
        System.out.println("Choose a number from the following: [1, 2, 3, 4]"); // Prompt User
        int choice_1 = scan_obj_1.nextInt(); // Read user Input

        // Decide which numbers to show next based on previous selection
        int starting = 0;
        int selection = starting + choice_1;

        // SECOND SELECTION //

        // Crete Second Scanner object
        Scanner scan_obj_2 = new Scanner(System.in);

        // Determine group - Even/Odd
        if (selection % 2 == 0) {
            // Even Selection
            System.out.println("Make a second selection from the following: " + even_list.toString());
        } else {
            // Odd Selection
            System.out.println("Make a second selection from the following: " + odd_list.toString());
        }
        // Read user's response
        int choice_2 = scan_obj_2.nextInt();

        // Add user's selection to the existing selection count
        selection += choice_2;

        // THIRD SELECTION //

        // Create third Scanner Object
        Scanner scan_obj_3 = new Scanner(System.in);

        // Third Choice: Determine group - Even/Odd
        if (selection % 2 == 0) {
            // Even Selection
            System.out.println("Make a third selection to get your fortune:" + even_list.toString());
        } else {
            // Odd Selection
            System.out.println("Make a third selection to get your fortune:" + odd_list.toString());
        }
        // Read user's response
        int choice_3 = scan_obj_3.nextInt();

        System.out.println("Your Fortune: ");
        System.out.println(fortune.get(choice_3));
    }
}
