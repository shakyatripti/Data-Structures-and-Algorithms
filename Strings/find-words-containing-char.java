//Problem: https://leetcode.com/problems/find-words-containing-character/description/




import java.io.*;
import java.util.*;

class WordsContainingChar {
    public List<Integer> findIndices(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
           for(char ch: words[i].toCharArray()) {
               if(ch==x) {
                  indices.add(i);
                  break;
               }
           }
        }
        return indices;
    }
    
    public void display(List<Integer> ans) {
        if(ans.size()==0) {
            System.out.println("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.print("\n");
    }
}


class Main {
    public static void main(String[] args) {
        WordsContainingChar validWords = new WordsContainingChar();
        String[] words = {"leet","code"};
        List<Integer> ans = validWords.findIndices(words, 'e');
        validWords.display(ans);
        
        String[] words1 = {"abc","bcd","aaaa","cbc", "pamn"};
        List<Integer> ans1 = validWords. findIndices(words1, 'a');
        validWords.display(ans1);
        
        String[] words2 = {"cat","mint","aroma","box"};
        List<Integer> ans2 = validWords. findIndices(words2, 'y');
        validWords.display(ans2);
    }
}