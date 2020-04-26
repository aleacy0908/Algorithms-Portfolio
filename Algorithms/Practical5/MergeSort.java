package Practical5;

import Practical4.InsertionSort;
import Resources.In;

public class MergeSort {

    public void sort(int[] arr, int left, int right){

        if(left < right){
            int middle = (left+right)/2;

            sort(arr, left ,middle);
            sort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    public void merge(int[] arr, int left, int middle, int right){

        int leftSize = middle-left+1;
        int rightSize = right-middle;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; ++i){
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < rightSize; ++i){
            rightArr[i] = arr[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize){
            if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize){
            arr[k] = rightArr[j];
            j++;
            k++;
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
                , "Resources/8Kints.txt", "Resources/16Kints.txt", "Resources/32Kints.txt", "Resources/64Kints.txt",
                "Resources/124Kints.txt"};
        MergeSort ms = new MergeSort();
        int[] arr;

        for (String file : files){
            In in = new In(file);
            arr = in.readAllInts();

            final long startTime = System.nanoTime();
            ms.sort(arr,0,arr.length-1);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println("Time it took for algorithm to sort integers in " + file + ": " + elapsedTime);
            //System.out.println(ms.printArray(arr));
        }

    }

}
