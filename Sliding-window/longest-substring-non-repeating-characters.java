//Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;
import java.io.*;

class LongestSubstringNonRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxlen=0;
        HashSet<Character> str = new HashSet<Character>();
        while(r < s.length()) {
            if(str.contains(s.charAt(r))) {
                while(str.contains(s.charAt(r))) {
                    str.remove(s.charAt(l));
                    l++;
                }
            }
            if(!str.contains(s.charAt(r))) {
                str.add(s.charAt(r));
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}

class Main {
    public static void main(String[] args) {
        String s = "pwwekx", s1="abcabcbbaa";
        LongestSubstringNonRepeatingChar longSubstring = new LongestSubstringNonRepeatingChar();
        System.out.println(longSubstring.lengthOfLongestSubstring(s));
        System.out.println(longSubstring.lengthOfLongestSubstring(s1));
        
    }
}