//Problem: https://leetcode.com/problems/count-prefixes-of-a-given-string/description/





import java.io.*;
import java.util.*;

class CountPrefixes {
    public int count(String[] words, String s) {
        int count = 0;
        String str = "";
        for(int i=0; i<s.length(); i++) {
            str+=s.charAt(i);
            for(int j=0; j<words.length; j++) {
                if(str.equals(words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountPrefixes str = new CountPrefixes();
        String[] words = {"a","b","c","ab","bc","abc"};
        System.out.println(str.count(words, "abc"));
        
        String[] words1 = {"a","a"};
        System.out.println(str.count(words1, "aa"));
    }
}