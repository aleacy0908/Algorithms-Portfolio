package Huffman.src.main;

import Huffman.src.huffman.HuffmanTree;
import Huffman.src.utilities.BinaryIn;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        //file to write to
        FileWriter newFile = new FileWriter(args[3]);

        //Read in original
        String inputFileDir = "./res/input.txt";
        File original = new File(inputFileDir);
        Scanner scanInput = new Scanner(original);

        //place all file text into a string for huffman
        StringBuilder originalInput  = new StringBuilder();
        while (scanInput.hasNext()){
            originalInput.append(scanInput.nextLine());
        }

        if (args[0].equals("compress")) {


            //Start test
            final long startTime = System.nanoTime();

            //Append Compressed Bits
            BinaryIn bi = new BinaryIn(args[1]);
            HuffmanTree tree = new HuffmanTree(bi.readString());
            String compressed = tree.getCompressedBits();
            newFile.append(compressed);

            //End test
            final long elapsedTime = System.nanoTime() - startTime;
            System.out.println(elapsedTime);

            FileWriter originalFile = new FileWriter(original);
            originalFile.write(bi.readString());

            originalFile.close();
            newFile.close();
            System.out.println("File compressed");
        }
        else if (args[0].equals("decompress")){

            final long startTime = System.nanoTime();

            BinaryIn bi = new BinaryIn(args[1]);
            HuffmanTree tree = new HuffmanTree(originalInput.toString());
            String decompressed = tree.decompressBits(bi.readString());
            newFile.append(decompressed);

            final long elapsedTime = System.nanoTime()-startTime;
            System.out.println(elapsedTime);

            newFile.close();
            System.out.println("File decompressed");
        }
        else throw new IllegalArgumentException("Illegal command line argument");

    }
}
