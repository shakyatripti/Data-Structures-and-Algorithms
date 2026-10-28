//Problem: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/




import java.io.*;
import java.util.*;


class MakeSubsequence {
    public int appendCharacters(String s, String t) {
        int l=0, r=0, n=s.length(), m=t.length();
        while(l < n && r < m) {
            if(s.charAt(l)==t.charAt(r)) {
                l++;
                r++;
            } else {
                l++;
            }
        }
        return m-r;
    }
}

class Main {
    public static void main(String[] args) {
        MakeSubsequence str = new MakeSubsequence();
        System.out.println(str.appendCharacters("coaching", "coding"));
        System.out.println(str.appendCharacters("abcde", "a"));
        System.out.println(str.appendCharacters("z", "abcde"));
    }
}