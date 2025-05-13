//Problem: https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/




import java.io.*;
import java.util.*;

class TotalCharsInString {
    public int lengthAfterTransformation(String s, int t) {
        int mod = (int) (1e9 + 7), len = 0;
        int[] mp = new int[26];
        for(int i=0; i<s.length(); i++) {
            mp[s.charAt(i)-'a']++;
        }
        for(int i=1; i<=t; i++) {
            int[] temp = new int[26];
            for(int k=0; k<26; k++) {
                char ch = (char) (k + 'a');
                if(ch!='z') {
                    temp[(ch+1)-'a'] = (temp[(ch+1)-'a'] + mp[k]) % mod;
                } else {
                    temp['a'-'a'] = (temp['a'-'a'] + mp[k]) % mod;
                    temp['b'-'a'] = (temp['b'-'a'] + mp[k]) % mod;
                }
            }
            mp = temp;
        }
        
        for(int i=0; i<26; i++) {
            len = (len + mp[i]) % mod;
        }
        
        return len;
    }
}

class Main {
    public static void main(String[] args) {
        TotalCharsInString str = new TotalCharsInString();
        System.out.println(str.lengthAfterTransformation("abcyy", 2));
        System.out.println(str.lengthAfterTransformation("azbk", 1));
    }
}