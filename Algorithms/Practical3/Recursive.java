package Practical3;

public class Recursive {

    static int fibonacciRecursive(int n){
        if(n==0){
            return 0;
        }else
        if(n==1){
            return 1;
        }
        return (fibonacciRecursive(n-1) + fibonacciRecursive(n-2));
    }


    public static void main(String[] args) {
        int n[] = {3,13,33,53,73,92,100,120,140,160,180,200};

        for (int i : n){
            long before = System.nanoTime();
            int result = fibonacciRecursive(i);
            long duration = System.nanoTime() - before;
            System.out.println("Amount of time to compute the first " + i + " fibonacci numbers in nanoseconds: " +
                    duration);
        }

    }
}
