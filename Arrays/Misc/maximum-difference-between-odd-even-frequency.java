//Problem: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/



import java.io.*;
import java.util.*;

class MaxDifference {
    public int diffEvenOddFreq(String s) {
        int a1=0, a2=Integer.MAX_VALUE;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
        }
        for(int i=0; i<26; i++) {
            if(freq[i]%2==0 && freq[i]>0) {
                a2 = Math.min(a2, freq[i]);
            } else {
                a1 = Math.max(a1, freq[i]);
            }
        }
        return a1-a2;
    }
}


class Main {
    public static void main(String[] args) {
        MaxDifference diff = new MaxDifference();
        System.out.println(diff.diffEvenOddFreq("aaaaabbc"));
        System.out.println(diff.diffEvenOddFreq("abcabcab"));
        System.out.println(diff.diffEvenOddFreq("yzyyys"));
        System.out.println(diff.diffEvenOddFreq("abbc"));
    }
}