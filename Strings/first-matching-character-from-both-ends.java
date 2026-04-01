//Problem: https://leetcode.com/problems/first-matching-character-from-both-ends/description/




import java.io.*;
import java.util.*;

class MatchingCharacters {
    public int firstIndex(String s) {
        int n=s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(n-i-1);
            if(ch==ch1) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        MatchingCharacters str = new MatchingCharacters();
        System.out.println(str.firstIndex("abcacbd"));
        System.out.println(str.firstIndex("abc"));
        System.out.println(str.firstIndex("abcdab"));
    }
}