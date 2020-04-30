package Practical9;

public class RunLength {

    public static String analyseRunLength(String input){

        StringBuilder compressed = new StringBuilder();

        //Run through the string and create string to report the count of each consecutive char
        for (int i = 0; i < input.length(); i++){
            int runCount = 1;
            char currLetter = input.charAt(i);

            //while i doesn't exceed string length and the current letter is the same as the next then
            //increment the count variable
            while (i < input.length()-1 && currLetter == input.charAt(i+1)){
                runCount++;
                i++;
            }

            compressed.append(input.charAt(i)).append(runCount);

        }

        return compressed.toString();
    }

    public static String expand(String input){

        StringBuilder uncompressed = new StringBuilder();

        //Recreate the uncompressed string from the compressed string
        for (int i = 0; i < input.length(); i++){
            //The current char is placed into a string for as many times the compressed string states
            char currChar = input.charAt(i);
            //Get the run length of the character
            int charCount = Character.getNumericValue(input.charAt(i+1));
            int j = 0;

            //Here the compressed string is uncompressed back into the normal string
            while (j != charCount){
                uncompressed.append(currChar);
                j++;
            }

            //In a RL encoded string, the char is always on a even place in the string
            //If the current place in the compressed string is odd, increment to the next char in the string
            if (i % 2 == 0){
                i++;
            }
        }

        return uncompressed.toString();
    }


    public static void main(String[] args) {
        String original = "aaaabbbbbccddddddd";
        String compressed = analyseRunLength(original);
        System.out.println("Original String compressed into: " + compressed);
        String uncompressed = expand(compressed);
        System.out.println("Compressed string expanded to original format: " + uncompressed);
    }
}
