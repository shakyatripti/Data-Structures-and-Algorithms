//Problem: https://leetcode.com/problems/words-within-two-edits-of-dictionary/description/





import java.io.*;
import java.util.*;

class WordsInDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int n=queries.length, m=dictionary.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(canBeSame(dictionary[j], queries[i])) {
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public boolean canBeSame(String s, String t) {
        int edits = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)) {
                edits++;
            }
        }
        if(edits <= 2) {
            return true;
        }
        return false;
    }
    
    public void display(List<String> ans) {
        if(ans.size()==0) {
            System.out.print("Empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        WordsInDictionary str = new WordsInDictionary();
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        List<String> ans = str.twoEditWords(queries, dictionary);
        str.display(ans);
        
        String[] queries1 = {};
        String[] dictionary1 = {};
        List<String> ans1 = str.twoEditWords(queries1, dictionary1);
        str.display(ans1);
    }
}