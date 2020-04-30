package Practical8;

public class Trie{

    // Alphabet size (# of symbols) we pick 26 for English alphabet
    static final int ALPHABET_SIZE = 26;


    // class for Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents end of a word i.e. leaf node
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;

            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;
    // If not key present, inserts into trie
    // If the key is prefix of Trie node,
    //  marks leaf node
    static void insert(String key){

        int index;

        //Set the current node as the root of the trie before traversing it
        TrieNode currNode = root;

        //If a letter from the key is not found in the trie then a new node is added
        //If the letter is already existing within the trie, that node is used as a prefix
        for (int trieLevel = 0; trieLevel < key.length(); trieLevel++){
            index = key.charAt(trieLevel) - 'a';

            if (currNode.children[index] == null){
                currNode.children[index] = new TrieNode();
            }

            currNode = currNode.children[index];
        }

        currNode.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key) {

        TrieNode currNode = root;
        int index = 0;

        for (int trieLevel = 0; trieLevel < key.length(); trieLevel++){
            index = key.charAt(trieLevel) - 'a';

            //If the length of the word exceeds the trie, return false
            if(currNode.children[index] == null){
                return false;
            }

            currNode = currNode.children[index];
        }

        //If the current node has a letter and is the end of the word then return true
        return (currNode != null && currNode.isEndOfWord);
    }


    // Driver
    public static void main(String args[]) {

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++) {
            insert(keys[i]);
        }

        // Search for different keys
        if (search("simple")) System.out.println(output[1]);
        else System.out.println(output[0]);

        if (search("word")) System.out.println(output[1]);
        else System.out.println(output[0]);

        if (search("bike")) System.out.println(output[1]);
        else System.out.println(output[0]);

        if (search("film")) System.out.println(output[1]);
        else System.out.println(output[0]);


    }

//end of class
}