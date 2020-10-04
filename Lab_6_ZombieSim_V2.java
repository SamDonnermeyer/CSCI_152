/*
Sam Donnermeyer
CSCI 152 Fall 2020
Lab #6
October 2, 2020
 */

package ZombieSim;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Create Timer
        long start_time = System.nanoTime();

        // Create the Arrays with the createWorld Method
        char zWorld[][] = createWorld();

        // Initialization Variables
        int x = 2, y = 2;       //coordinates of Patient Zero
        int immunity_rate = 10; // Immunity Rate

        // ### Modify the 'world' ### //
        // fill array with a period character '.'
        populate(zWorld, immunity_rate);

        // print the matrix
        outputWorld(zWorld);

        // place a zombie 'Z' at the location of Patient Zero
        infect(zWorld, x, y);


        // End Timer and Display Elapsed Time
        long stop_time = System.nanoTime();
        long elapsed_time = stop_time - start_time;
        System.out.println("Time Elapsed (Nanoseconds): " + elapsed_time);
    }

    // createWorld Method
    public static char[][] createWorld() {
        // Create new array
        char new_array[][] = new char [10][10];
        return new_array;
    }

    // populate Method
    public static void populate(char matrix[][], int immunity) {
        int max = 99;
        Random rand = new Random(); // Instance of Random Class

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Random Int for immunity
                int random_int = rand.nextInt(max) + 1;

                // Determine Immunity
                if (random_int <= immunity) {
                    matrix[i][j] = 'i';
                } else {
                    matrix[i][j] = '.';
                }
            }
        }
    }

    // outputWorld Method
    public static void outputWorld(char matrix[][]) {
        System.out.println();
        // Loop through all rows
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            // Loop through all elements of current row
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
        }
    }

    // Infect Method
    public static void infect(char matrix[][], int x, int y) {
        //method to check the nearest neighbors of a given cell, then move "out"
        int row = 0, col = 0;
        int numIterations = 1;
        int num_iterations = 0;
        int numOutofBounds = 0;
        int num_loops = 0;

        //int maxIterations = calculateNumIterations(sRow, sCol);
        int maxIterations = matrix.length - 1;  // can be changed for efficiency

        // Infect First Person
        matrix[x][y] = 'Z';

        // Output Snapshot
        outputWorld(matrix);   // print the Patient Zero matrix

        while (numIterations <= maxIterations) {
            for (row = x - numIterations; row <= x + numIterations; row++) {
                if (row >= 0 & row < matrix.length) {
                        for (col = y - numIterations; col <= y + numIterations; col++) {
                            if (col >= 0 & col < matrix[row].length){
                                try {
                                    if (matrix[row][col] != 'i') {
                                        matrix[row][col] = 'Z';
                                    }
                                } catch (IndexOutOfBoundsException ex) {
                                    //do nothing, just keep running
                                    numOutofBounds++;
                                }
                                num_iterations++;
                            }
                        }
                    }
                }
            outputWorld(matrix);
            num_loops++;
            numIterations++;
        }

        // Print the number of OOB errors
        System.out.println();
        System.out.println();
        System.out.println("Out of Bounds Errors: " + numOutofBounds);
        System.out.println("Loop Iterations: " + num_iterations);
        System.out.println("Loop Executions: " + num_loops);
    }


}  //end class