//Problem: https://leetcode.com/problems/merge-strings-alternately/description/



import java.io.*;
import java.util.*;


class AlternateStrings {
    public String merge (String word1, String word2) {
        int n=word1.length(), m=word2.length(), len = Math.min(n, m), i=0;
        String ans = "";
        for(i=0; i<len; i++) {
           ans+=word1.charAt(i);
           ans+=word2.charAt(i);
        }
        

        while(i < word1.length()) {
            ans+=word1.charAt(i);
            i++;
        }

        while(i < word2.length()) {
            ans+=word2.charAt(i);
            i++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        AlternateStrings str = new AlternateStrings();
        System.out.println(str.merge("abc", "pqr"));
        System.out.println(str.merge("ab", "pqrs"));
        System.out.println(str.merge("abcd", "pq"));
        System.out.println(str.merge("cdf", "a"));
    }
}