package Practical4;

import Resources.In;

public class StalinSort {

    public int[] removeOutOfOrderElements(int[] arr, int size){

        int[] temp = new int[size];
        int j = 1;
        temp[0] = arr[0];

        for (int i = 1; i < size; i++){
            if (temp[j - 1] <= arr[i]){
                temp[j] = arr[i];
                j++;
            }
        }

        return temp;
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
                , "Resources/8Kints.txt", "Resources/16Kints.txt", "Resources/32Kints.txt"};
        StalinSort ss = new StalinSort();
        int[] arr;

        for (String file : files){
            In in = new In(file);
            arr = in.readAllInts();

            final long startTime = System.nanoTime();
            arr = ss.removeOutOfOrderElements(arr, arr.length);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println("Time it took for algorithm to sort integers in " + file + ": " + elapsedTime);
            //System.out.println(ss.printArray(arr));
        }

    }

}
