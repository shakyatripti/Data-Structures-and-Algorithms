//Problem: https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/



import java.io.*;
import java.util.*;

class AdjacentPairs {
    public int countRotations(String s, int k) {
        int n=s.length(), i=0, count=0;
        StringBuilder str = new StringBuilder(s);
        while(i < n) {
            str.append(str.charAt(0));
            str.deleteCharAt(0);
            int score = 0;
            for(int j=0; j<n-1; j++) {
                if(str.charAt(j)==str.charAt(j+1)) {
                    score++;
                }
            }
            if(score==k) {
                count++;
            }
            i++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        AdjacentPairs pairs = new AdjacentPairs();
        System.out.println(pairs.countRotations("aab", 1));
        System.out.println(pairs.countRotations("abca", 0));
    }
}