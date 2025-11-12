//Problem: https://leetcode.com/problems/palindromic-substrings/description/




import java.io.*;
import java.util.*;

class PalindromicSubstrings {
    public int count(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            String ans = "";
            for(int j=i; j<s.length(); j++) {
                ans+=s.charAt(j);
                if(isPalindromic(ans)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPalindromic(String s) {
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(s.charAt(i)!=s.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        PalindromicSubstrings str = new PalindromicSubstrings();
        System.out.println(str.count("abc"));
        System.out.println(str.count("aaa"));
    }
}