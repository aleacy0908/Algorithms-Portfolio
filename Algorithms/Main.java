import Practical1.RussianPeasantAlgorithm;
import Practical2.ThreeSumA;
import Practical2.ThreeSumB;
import Practical3.Iterative;
import Practical3.Recursive;
import Practical3.hanoi;
import Practical4.InsertionSort;
import Practical4.SelectionSort;
import Practical4.StalinSort;
import Practical5.MergeSort;
import Practical6.QuickSort;
import Practical7.BruteForce;
import Practical7.KMPsearch;
import Practical8.Trie;
import Practical9.RunLength;

public class Main {

    public static void main(String[] args) {

        System.out.println("Running main methods from each algorithm:\n");

        System.out.println("--- Russian Peasant Algorithm ---");
        RussianPeasantAlgorithm.main(null);

        System.out.println();

        System.out.println("--- ThreeSumA ---");
        ThreeSumA.main(null);
        System.out.println();

        System.out.println("--- ThreeSumB ---");
        ThreeSumB.main(null);

        System.out.println();


        System.out.println("--- Tower Of Hanoi ---");
        hanoi.main(null);
        System.out.println();
        System.out.println("--- Fibonacci Iterative ---");
        Iterative.main(null);
        System.out.println();
        System.out.println("--- Fibonacci Recursive ---");
        Recursive.main(null);

        System.out.println();

        System.out.println("--- Insertion Sort ---");
        InsertionSort.main(null);
        System.out.println();
        System.out.println("--- Selection Sort ---");
        SelectionSort.main(null);
        System.out.println();
        System.out.println("--- Stalin Sort ---");
        StalinSort.main(null);
        System.out.println();

        System.out.println("--- Merge Sort ---");
        MergeSort.main(null);

        System.out.println();

        System.out.println("--- Quick Sort ---");
        QuickSort.main(null);

        System.out.println();

        System.out.println("--- BruteForce Sub-String Search ---");
        BruteForce.main(null);
        System.out.println();
        System.out.println("--- KMPsearch ---");
        KMPsearch.main(null);
        System.out.println();

        System.out.println("--- Trie ---");
        Trie.main(null);

        System.out.println();

        System.out.println("--- Run Length Encoding ---");
        RunLength.main(null);

    }

}
