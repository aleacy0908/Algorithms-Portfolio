package Practical4;

import Resources.In;

public class InsertionSort {

    public InsertionSort(Comparable[] arr, int low, int high){
        sort(arr, low, high);
    }

    public InsertionSort(){ }

    public void sort(int[] arr){

        for (int i = 1; i < arr.length; ++i){

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

    public void sort(Comparable[] arr, int low, int high){

        for (int i = low; i < high+1; ++i){

            int key = (int) arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

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
                , "Resources/8Kints.txt", "Resources/16Kints.txt", "Resources/32Kints.txt"};
        InsertionSort ss = new InsertionSort();
        int[] arr;

        for (String file : files){
            In in = new In(file);
            arr = in.readAllInts();


            final long startTime = System.nanoTime();
            ss.sort(arr);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println("Time it took for algorithm to sort integers in " + file + ": " + elapsedTime);
            //System.out.println(ss.printArray(arr));
        }

    }

}
