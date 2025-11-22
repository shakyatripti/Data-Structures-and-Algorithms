//Problem: https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/




import java.io.*;
import java.util.*;

class BalancedRemovals {
    public int minLengthAfterRemovals(String s) {
        int[] freq = new int[2];
        for(char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        return Math.abs(freq[0]-freq[1]);
    }
}

class Main {
    public static void main(String[] args) {
        BalancedRemovals str = new BalancedRemovals();
        System.out.println(str.minLengthAfterRemovals("aabbab"));
        System.out.println(str.minLengthAfterRemovals("aaaa"));
        System.out.println(str.minLengthAfterRemovals("aaabb"));
        System.out.println(str.minLengthAfterRemovals("bbbba"));
    }
}