//Problem: https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/description/



import java.io.*;
import java.util.*;



class BinaryString {
    public int numTimesAllBlue(int[] flips) {
        int count = 0, n = flips.length, maxPos = 0, curr = 0;
        for(int i=0; i<n; i++) {
            maxPos = Math.max(maxPos, flips[i]);
            curr++;
            if(maxPos == curr) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryString str = new BinaryString();
        int[] flips = {3,2,4,1,5};
        System.out.println(str.numTimesAllBlue(flips));
        
        int[] flips1 = {4,1,2,3};
        System.out.println(str.numTimesAllBlue(flips1));
    }
}