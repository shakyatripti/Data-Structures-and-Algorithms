//Problem: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/




import java.io.*;
import java.util.*;

class BeautySum {
    public int calcBeauty(String s) {
        int sum = 0, minfreq = Integer.MAX_VALUE, maxfreq = 0;
        for(int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            freq[s.charAt(i)-'a']++;
            for(int j=i+1; j<s.length(); j++) {
                freq[s.charAt(j)-'a']++;
                for(int k=0; k<freq.length; k++) {
                    if(freq[k] > 0) {
                        minfreq = Math.min(minfreq, freq[k]);
                        maxfreq = Math.max(maxfreq, freq[k]);
                    }
                }
                sum+=maxfreq-minfreq;
                maxfreq = 0;
                minfreq = Integer.MAX_VALUE;
            }
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        BeautySum sum = new BeautySum();
        System.out.println(sum.calcBeauty("aabcb"));
        System.out.println(sum.calcBeauty("aabcbaa"));
        System.out.println(sum.calcBeauty("abc"));
    }
}