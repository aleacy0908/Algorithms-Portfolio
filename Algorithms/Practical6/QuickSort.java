package Practical6;

import Practical4.InsertionSort;
import Resources.In;

import java.util.Collections;
import java.util.Random;

public class QuickSort {

    private int partition(Comparable [] arr, int lo, int hi){

        int median = (hi+lo)/2;
        Comparable pivot = arr[hi];
        int i = lo-1;

        for (int j = lo; j <= hi-1; j++){
            if (arr[j].compareTo(pivot) < 0){
                i++;

                int temp = (int) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = (int) arr[i+1];
        arr[i+1] = arr[hi];
        arr[hi] = temp;

        return i+1;
    }

    public void sort(Comparable[] arr, int low, int high){

        if (high <= low + 10){
            InsertionSort is = new InsertionSort(arr, low, high);
        } else {

            // Sort low, middle, high
            int middle = ( low + high ) / 2;
            if( arr[middle].compareTo( arr[ low ] ) < 0 )
                swapReferences( arr, low, middle );
            if( arr[high].compareTo( arr[ low ] ) < 0 )
                swapReferences( arr, low, high );
            if( arr[high].compareTo( arr[ middle ] ) < 0 )
                swapReferences( arr, middle, high );

            // Place pivot at position high - 1
            swapReferences( arr, middle, high - 1 );
            Comparable pivot = arr[ high - 1 ];

            int pi = partition(arr,low,high);

            // Restore pivot
            swapReferences( arr, pi, high - 1 );

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }

    }

    public static final void swapReferences( Object [ ] a, int index1, int index2 ) {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    public static void shuffleArray(Comparable[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(Comparable[] a, int i, int change) {
        int helper = (int) a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    public String printArray(int[] arr){

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < arr.length; i++){
            if (i == arr.length-1) sb.append(arr[i]);
            else sb.append(arr[i]).append(", ");
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] files = { "Resources/8ints.txt", "Resources/1Kints.txt", "Resources/2Kints.txt", "Resources/4Kints.txt"
                , "Resources/8Kints.txt", "Resources/16Kints.txt", "Resources/32Kints.txt", "Resources/64Kints.txt",
                "Resources/124Kints.txt"};
        QuickSort qs = new QuickSort();



        for (String file : files){
            int[] temp;
            In in = new In(file);
            temp = in.readAllInts();
            Comparable[] arr = new Comparable[temp.length];

            for (int i = 0; i < temp.length; i++){
                arr[i] = temp[i];
            }

            shuffleArray(arr);

            final long startTime = System.nanoTime();
            qs.sort(arr,0,arr.length-1);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println("Time it took for algorithm to sort integers in " + file + ": " + elapsedTime);
            //System.out.println(qs.printArray(arr));
        }
    }

}

