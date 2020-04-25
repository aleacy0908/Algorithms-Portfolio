package Practical1;

public class RussianPeasantAlgorithm {

    public static void main(String[] args) {

        final long startTime = System.nanoTime();
        System.out.println(algorithm(200000,212340));
        final long finalTime = System.nanoTime() - startTime;
        System.out.println("the time taken " + finalTime);

    }


    public static int algorithm(int n, int m){

        int accumulator = 0;

        while(n>1){
            if(n%2 == 0){
                n = n/2;
                m = m*2;
            }
            else {
                n = (n - 1) / 2;
                accumulator = accumulator + m;
                m = m * 2;
            }

        }

        return accumulator + m;
    }


}
