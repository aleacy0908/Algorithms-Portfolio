
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
        int n=30;
        long before = System.currentTimeMillis();
        System.out.println(fibonacciRecursive(n));
        long duration = System.currentTimeMillis() - before;
        System.out.println("amount of time taken: " + duration + "");
    }
}
