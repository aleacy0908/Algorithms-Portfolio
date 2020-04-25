package Practical3;

public class hanoi {

    public static void main(String[] args) {

        towerOfHanoi(3,'A','C','B');
    }

    static void towerOfHanoi(int disk, char source, char dest, char aux){
        if(disk == 1){
            System.out.println("Move disk from " + source + " to " + dest);
        }else {
            towerOfHanoi(disk - 1, source, aux, dest);
            System.out.println("Move disk from " + source + " to " + dest);
            towerOfHanoi(disk - 1, aux, dest, source);
        }
    }
}
