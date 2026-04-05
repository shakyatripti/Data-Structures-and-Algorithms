//Problem: https://leetcode.com/problems/mirror-frequency-distance/description/




import java.io.*;
import java.util.*;


class MirrorFrequency {
    public int calcDistance(String s) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[10];
        int sum = 0;
        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            int num = ch - '0';
            if(val >= 0 && val < 26) {
                freq1[val]++;
            } else {
                freq2[num]++;
            }
        }

        for(int i=0; i<=12; i++) {
            sum+=Math.abs(freq1[i] - freq1[25-i]);
        }
        
        for(int i=0; i<=4; i++) {
            sum+=Math.abs(freq2[i] - freq2[9-i]);
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        MirrorFrequency str = new MirrorFrequency();
        System.out.println(str.calcDistance("ab1z9"));
        System.out.println(str.calcDistance("4m7n"));
        System.out.println(str.calcDistance("byby"));
        System.out.println(str.calcDistance("363"));
    }
}