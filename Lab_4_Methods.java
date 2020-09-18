/*
Sam Donnermeyer
CSCI 152 Fall 2020
Lab #4
September 17, 2020
 */

import java.util.*;
public class Main {

    // Method for #1
    public static int add(int x, int y) {
        // Add the two integers
        int return_sum = x + y;

        // Print sum
        System.out.println(return_sum);
        return return_sum;
    }

    // Method for #2
    public static void payroll(String employeeName, float hoursWorked, float hourlyPay, float taxRate) {
        // Print Payroll Report //
        // Gross Pay
        float gross_pay = hoursWorked * hourlyPay;
        float total_taxes = gross_pay * taxRate;
        float net_pay = gross_pay - total_taxes;

        // Print Report
        System.out.println(employeeName + "'s Payroll information:");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Wage: " + hourlyPay);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("-----------");
        System.out.println("Gross Pay: $" + gross_pay);
        System.out.println("Total Taxes: $" + total_taxes);
        System.out.println("Net Pay: $" + net_pay);
    }

    // Method for #3
    public static float grossPay(float hoursWorked, float hourlyWage) {
        // Calculate Gross Pay
        float gross_pay = hoursWorked * hourlyWage;

        return gross_pay;
    }

    // Method for #4
    public static float netPay(float grossPay, float taxRate) {
        // Calculate Net Pay
        float net_pay = grossPay - (grossPay * taxRate);

        return net_pay;
    }

    // Method for #5
    public static int largestArray(int[] user_array) {
        // Traverse through array for largest value
        int max = user_array[0];

        // Traversal
        for (int i = 1; i < user_array.length; i++)
        {
            // Get largest value out of the two
            if (user_array[i] > max)
            {
                max = user_array[i];
            }
        }

        return max;
    }

    // Method for #6.1 - Fortune Getter
    public static void fortune_getter(int user_number) {
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

        // Get the user's fortune
        System.out.println(fortune.get(user_number));
    }

    // Method for #6.2 - print even/odd list
    public static void even_odd_listing(int user_selection) {
        // Initialize the lists
        // Initialize the even/odd groups
        List<Integer> even_list = Arrays.asList(1, 2, 5, 6);
        List<Integer> odd_list = Arrays.asList(3, 4, 7, 8);

        // Get correct list to chose from
        if (user_selection % 2 == 0) {
            // Even Selection
            System.out.println("Make a selection from the following: " + even_list.toString());
        } else {
            // Odd Selection
            System.out.println("Make a selection from the following: " + odd_list.toString());
        }
    }

    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////////////
	    // 1. Write a method 'add' that takes two integers, x and y, as arguments & returns the sum
        System.out.println("Problem 1:");

        // Method Call
        int result = add(2, 3);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // 2. Write a method that takes a string and three floating point numbers as arguments:
        // employeeName, hoursWorked, hourlyPay and taxRate; and prints a payroll report for the employee.
        // This method will not have a return value.
        System.out.println("Problem 2:");

        // Method Call
        payroll("Sam", 25.0f, 12.50f, .04f);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // 3. Write a method that accepts hoursWorked and hourlyPay as arguments and returns grossPay.
        System.out.println("Problem 3:");

        // Method Call
        float gross_pay = grossPay(25.0f, 12.5f);
        System.out.println("Gross Pay: $" + gross_pay);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // 4. Write a method that accepts grossPay and taxRate and returns netPay.
        System.out.println("Problem 4:");

        // Method Call
        float net_pay = netPay(grossPay(25.0f, 12.5f), .04f);
        System.out.println("Net Pay: $" + net_pay);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // 5. Write a method that accepts an array of integers as an argument, and returns the largest integer in
        // the array. (You must do this with a traversal – do not use any built-in methods!)
        System.out.println("Problem 5:");

        // Method Call //
        // Initialize the array
        int[] array_max = {10, 3, 6, 15, 22, 45, 13, 2, 9, 33, 42};
        int max_num = largestArray(array_max);
        System.out.println("Max Integer in Array: " + max_num);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // 6. Reorganize your Fortune Teller program into methods. This is a design problem – think of ways to
        // break your program up into small, reusable tasks that may be called in a specific order to
        // accomplish the same purpose as your original program.
        System.out.println("Problem 6: Fortune Teller Upgrade");

        // Fortune Teller //

        // Get first selection //
        Scanner scan_obj_1 = new Scanner(System.in); // Create Scanner object
        System.out.println("Choose a number from the following: [1, 2, 3, 4]"); // Prompt User
        int selection = scan_obj_1.nextInt(); // Read user Input

        // Get Second Selection //
        even_odd_listing(selection);

        // Read user's response
        selection += scan_obj_1.nextInt();

        // Get Third Selection //
        even_odd_listing(selection);

        // Read user's response
        selection = scan_obj_1.nextInt();

        // PRINT FORTUNE //
        System.out.println("Your Fortune: ");
        fortune_getter(selection);

    }
}
