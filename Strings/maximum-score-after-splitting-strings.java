//Problem: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/





import java.io.*;
import java.util.*;



class SplitString {
    public int maxScore(String s) {
        int zeroes=0, ans=0;
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)=='0') {
                zeroes++;
            }
            int ones = 0;
            for(int j=i+1; j<s.length(); j++) {
                if(s.charAt(j)=='1') {
                    ones++;
                }
            }
            ans = Math.max(ans, ones+zeroes);
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        SplitString str = new SplitString();
        System.out.println(str.maxScore("011101"));
        System.out.println(str.maxScore("00111"));
        System.out.println(str.maxScore("1111"));
        System.out.println(str.maxScore("00"));
    }
}