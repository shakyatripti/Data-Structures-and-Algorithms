//Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/


//Brute Force solution
import java.io.*;
import java.util.*;

class CountOfSubStrings {
    public int countValidSubstrings(String word) {
        int n=word.length(), ans = 0, l=0;
        HashMap<Character, Integer> freq = new HashMap<>(3);
        for(int i=0; i<n; i++) {
            char curr = word.charAt(i);
            if(isValidChar(curr)) {
                freq.put(curr, freq.getOrDefault(curr, 0) + 1);
            }
            while(freq.size()==3) {
                ans+=n-i;
                char ch = word.charAt(l);
                if(isValidChar(ch)) {
                    freq.put(ch, freq.get(ch)-1);
                    if(freq.get(ch)==0) {
                        freq.remove(ch);
                    }
                }
                l++;
            }
        }
        return ans;
    }
    
    public boolean isValidChar(Character ch) {
        if(ch=='a' || ch=='b' || ch=='c') {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        CountOfSubStrings str = new CountOfSubStrings();
        System.out.println(str.countValidSubstrings("abcabc"));
        System.out.println(str.countValidSubstrings("aaabc"));
    }
}