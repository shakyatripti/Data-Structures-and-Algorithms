//Problem:
https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/description/





import java.io.*;
import java.util.*;



class RangeCoverage {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] freq = new int[51];
        for(int i=0; i<ranges.length; i++) {
            for(int j=ranges[i][0]; j<=ranges[i][1]; j++)
            freq[j]++;
        }

        for(int i=left; i<=right; i++) {
            if(freq[i]==0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        RangeCoverage num = new RangeCoverage();
        int[][] range = {{1,2},{3,4},{5,6}};
        System.out.println(num.isCovered(range,2,5));
        
        int[][] range1 = {{1,10},{10,20}};
        System.out.println(num.isCovered(range1,21,21));
        
        int[][] range2 = {{1,50}};
        System.out.println(num.isCovered(range2,1,50));
    }
}