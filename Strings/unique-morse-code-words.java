//Problem: https://leetcode.com/problems/unique-morse-code-words/description/



import java.io.*;
import java.util.*;

class UniqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
        "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> newWords = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            String ans="";
            for(char ch: words[i].toCharArray()) {
                int text = ch - 'a';
                ans+=code[text];
            }
            newWords.add(ans);
        }
        return newWords.size();
    } 
}

class Main {
    public static void main(String[] args) {
        UniqueMorseCode code = new UniqueMorseCode();
        String[] words = {"gin","zen","gig","msg"};
        System.out.println(code.uniqueMorseRepresentations(words));
        
        String[] words1 = {"ab"};
        System.out.println(code.uniqueMorseRepresentations(words1));
        
        String[] words2 = {"toy","yes","nuts","top"};
        System.out.println(code.uniqueMorseRepresentations(words2));
    }
}