package Practical2; /******************************************************************************
 *  Compilation:  javac ThreeSumA.java
 *  Execution:    java ThreeSum input.txt
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 ******************************************************************************/

import Resources.In;

import java.util.concurrent.TimeUnit;

public class ThreeSumA {

    // Do not instantiate.
    private ThreeSumA() { }



    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  {

        String[] arr = { "Resources/8ints.txt", "Resources/1Kints.txt", "Resources/2Kints.txt", "Resources/4Kints.txt"
                , "Resources/8Kints.txt", "Resources/16Kints.txt", "Resources/32Kints.txt"};

        for (int i = 0; i < 7; i++){

            In in = new In(arr[i]);
            int[] a = in.readAllInts();

            final long startTime = System.nanoTime();
            int count = count(a);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println(arr[i] + " Count: " + count);
            System.out.println("Time Taken for algorithm to run in nanoseconds: " + elapsedTime);
            long milliseconds = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
            System.out.println("Time Taken for algorithm to run in milliseconds: " + milliseconds);

        }



              
    } 
} 


