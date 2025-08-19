//Problem: https://leetcode.com/problems/minimize-string-length/description/




import java.io.*;
import java.util.*;

class StringLength {
    public int minimized(String s) {
        int count = 0;
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            if(freq[ch-'a']==0) {
                count++;
            } 
            freq[ch-'a']++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        StringLength str = new StringLength();
        System.out.println(str.minimized("aaabc"));
        System.out.println(str.minimized("baadccab"));
        System.out.println(str.minimized("cbbd"));
    }
}