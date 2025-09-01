//Problem: https://leetcode.com/problems/permutation-difference-between-two-strings/description/




import java.io.*;
import java.util.*;

class TwoStringsPermutation {
    public int findDifference(String s, String t) {
        int ans = 0;
        int[] index = new int[26];
        for(int i=0; i<t.length(); i++) {
            int ch = t.charAt(i) - 'a';
            index[ch] = i;
        }
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            ans+= Math.abs(i - index[ch]);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        TwoStringsPermutation str = new TwoStringsPermutation();
        System.out.println(str.findDifference("abc", "bac"));
        System.out.println(str.findDifference("abcde", "edbac"));
    }
}