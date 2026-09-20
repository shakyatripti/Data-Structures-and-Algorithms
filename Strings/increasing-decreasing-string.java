//Problem: https://leetcode.com/problems/increasing-decreasing-string/description/





import java.io.*;
import java.util.*;


class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] freq = new int[26];
        String ans="";
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        while(ans.length()!=s.length()) {
            for(int i=0; i<26; i++) {
                if(freq[i] > 0) {
                    ans+=(char) (i + 'a');
                    freq[i]--;
                }
            }

            for(int i=25; i>=0; i--) {
                if(freq[i] > 0) {
                    ans+=(char) (i + 'a');
                    freq[i]--;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        IncreasingDecreasingString str = new IncreasingDecreasingString();
        System.out.println(str.sortString("aaaabbbbcccc"));
        System.out.println(str.sortString("rat"));
    }
}