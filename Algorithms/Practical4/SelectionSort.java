package Practical4;

import Resources.In;

public class SelectionSort {

    public void sort(int[] arr){

        int n = arr.length;

        for (int i = 0; i < n-1; i++){

            int minNum = i;

            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[minNum]) minNum = j;
            }

            int temp = arr[minNum];
            arr[minNum] = arr[i];
            arr[i] = temp;
        }
    }

    public String printArray(int[] arr){

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < arr.length-1; i++){
            if (i == arr.length-2) sb.append(arr[i]);
            else sb.append(arr[i]).append(", ");
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] files = { "Resources/8ints.txt", "Resources/1Kints.txt", "Resources/2Kints.txt", "Resources/4Kints.txt"
                , "Resources/8Kints.txt", "Resources/16Kints.txt", "Resources/32Kints.txt"};        SelectionSort ss = new SelectionSort();
        for (String file : files){
            In in = new In(file);
            int[] arr = in.readAllInts();

            final long startTime = System.nanoTime();
            ss.sort(arr);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println("Time it took for algorithm to sort integers in " + file + ": " + elapsedTime);
        }

    }

}
