package Practical3;

public class Iterative {

    static int fibonacciIterative(int n){
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static void main (String args[])
    {
        int n[] = {3,13,33,53,73,92,100,120,140,160,180,200};

        for (int i : n){
            long before = System.nanoTime();
            int result = fibonacciIterative(i);
            long duration = System.nanoTime() - before;
            System.out.println("Amount of time to compute the first " + i + " fibonacci numbers in nanoseconds: " +
                    duration);
        }


    }


}
