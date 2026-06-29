//Problem: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/description/





import java.io.*;
import java.util.*;


class StringsInPattern {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        List<String> substr = new ArrayList<>();
        for(int i=0; i<word.length(); i++) {
            for(int j=i; j<word.length(); j++) {
                substr.add(word.substring(i,j+1));
            }
        }

        for(int i=0; i<patterns.length; i++) {
            if(substr.contains(patterns[i])) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        StringsInPattern arr = new StringsInPattern();
        String[] patterns = {"a","abc","bc","d"};
        System.out.println(arr.numOfStrings(patterns, "abc"));
        
        String[] patterns1 = {"a","b","c"};
        System.out.println(arr.numOfStrings(patterns1, "aaaaabbbbb"));
        
        String[] patterns2 = {"a","a","a"};
        System.out.println(arr.numOfStrings(patterns2, "ab"));
        
    }
}