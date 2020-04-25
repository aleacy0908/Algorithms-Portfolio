package Practical3;

public class hanoi {

    public static void main(String[] args) {

        int n[] = {3,6,9,12,15,18,21,24,27,30};

        for (int i : n){
            long before = System.nanoTime();
            towerOfHanoi(i,'A','B', 'C');
            long duration = System.nanoTime() - before;
            System.out.println("Amount of time to complete the tower of hanoi with " + i + " disks in nanoseconds: " +
                    duration);
        }
    }

    static void towerOfHanoi(int disk, char source, char dest, char aux){
        if(disk == 1){
            //System.out.println("Move disk from " + source + " to " + dest);
        }else {
            towerOfHanoi(disk - 1, source, aux, dest);
            //System.out.println("Move disk from " + source + " to " + dest);
            towerOfHanoi(disk - 1, aux, dest, source);
        }
    }
}
