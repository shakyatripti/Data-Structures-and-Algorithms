//Problem:https://leetcode.com/problems/digit-frequency-score/description/



import java.io.*;
import java.util.*;


class DigitFrequency {
    public int findScore(int n) {
        int ans = 0;
        int[] freq = new int[10];
        while(n!=0) {
            int r = n%10;
            n = n/10;
            freq[r]++;
        }

        for(int i=0; i<10; i++) {
            ans+=freq[i]*i;
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        DigitFrequency digit = new DigitFrequency();
        System.out.println(digit.findScore(101));
        System.out.println(digit.findScore(122));
    }
}