package Practical7;

public class BruteForce {

    public static int search(String txt, String pat)
    {
        int txtLength = txt.length();
        int patLength = pat.length();
        int j;

        for (int pos = 0; pos < txtLength - patLength; pos++){
            //System.out.println(pos);

            for (j = 0; j < patLength; j++) {
                //System.out.println(j+""+(txt.charAt(pos+j))+""+pat.charAt(j));
                if (txt.charAt(pos + j) != pat.charAt(j)) break;
            }

            if (j == patLength){
                //System.out.println(j);
                return pos;
            }
        }

        return txtLength;
    }

    public static void printString(String txt, int pos, int patLength){

        StringBuilder sb = new StringBuilder();
        int j = pos==txt.length() ? txt.length()-patLength : pos;

        for (int i = 0; i < patLength; i++){
            sb.append(txt.charAt(j));
            j++;
        }

        System.out.println(sb.toString());

    }


    // Driver program to test above function
    public static void main(String args[])
    {
        String[] txt = {"SSDABABCABAB", "DSDFFFAFAFABABCABAB", "BSFDSFDSFAABABCABABCABAB",
                "ABFSFVCVXCSFSFABDABACDABABCABAB", "ABSFXVXVXZSFSFDSABCABABEFVSVADFVAD",
                "FDASABVXVXABCABABFMNOVNAODNOFNEABABCABAB", "ADFDFVXZZVDSAGABABCABABEFSDFVSDVSDABABCABABEFVEF"};
        String pat = "ABABCABAB";


        for (String text : txt){
            final long startTime = System.nanoTime();
            search(pat, text);
            final long elapsedTime = System.nanoTime()-startTime;

            System.out.println("Time it took for algorithm to find the pattern in " + text + ": " + elapsedTime);
        }

    }

}
