package Practical2; /******************************************************************************
 *  Compilation:  javac ThreeSumB.java
 *  Execution:    java ThreeSumB input.txt
 *
 *  Reads n integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *     - doesn't handle case when input has duplicates
 *     
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 ******************************************************************************/

import Resources.In;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class ThreeSumB {

    // Do not instantiate.
    private ThreeSumB() { }

    // returns true if the sorted array a[] contains any duplicated integers
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
    }

  
    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) count++;
            }
        }
        return count;
    } 

    /**
     * Reads in a sequence of distinct integers from a file, specified as a command-line argument;
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

