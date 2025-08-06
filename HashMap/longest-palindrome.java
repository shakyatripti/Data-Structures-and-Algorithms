//Problem: https://leetcode.com/problems/longest-palindrome/description/




import java.io.*;
import java.util.*;


class LongestPalindrome {
    public int findLongest(String s) {
        int len = 0;
        boolean middle = false;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char ch: s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry entry: mp.entrySet()) {
            int freq = (Integer) entry.getValue();
            if(freq%2==0) {
                len+=freq;
            } else {
                len+=freq-1;
                middle = true;
            }
        }
        if(middle) {
            len++;
        }
        return len;
    }
}


class Main {
    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.findLongest("abccccdd"));
        System.out.println(palindrome.findLongest("r"));
        System.out.println(palindrome.findLongest("ccc"));
    }
}