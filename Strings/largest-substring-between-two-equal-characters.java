//Problem: https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/






import java.io.*;
import java.util.*;


class LargestSubstring {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            for(int j=i+1; j<s.length(); j++) {
                if(s.charAt(j)==ch) {
                    ans = Math.max(ans, j-i-1);
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LargestSubstring str = new LargestSubstring();
        System.out.println(str.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(str.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(str.maxLengthBetweenEqualCharacters("cbzxy"));
    }
}