//Problem: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/


import java.io.*;
import java.util.*;

class LexicographicalString {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, "", happyStrings);
        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }
    
    public void backtrack(int n, String str, List<String> happyStrings) {
        if (str.length() == n) {
            happyStrings.add(str);
            return;
        }
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (str.isEmpty() || str.charAt(str.length() - 1) != ch) {
                backtrack(n, str + ch, happyStrings);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        LexicographicalString str = new LexicographicalString();
        System.out.println(str.getHappyString(3, 9)); 
    }
}
