//Problem: https://leetcode.com/problems/number-of-intersecting-interval-pairs-i/description/




import java.io.*;
import java.util.*;


class IntersectingIntervalsI {
    public int countPairs(int[][] intervals) {
        int n=intervals.length, count=0;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0], b[0]));
        for(int i=0; i<n; i++) {
            int end = intervals[i][1];
            for(int j=i+1; j<n; j++) {
                if(end >= intervals[j][0]) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        IntersectingIntervalsI arr = new IntersectingIntervalsI();
        int[][] intervals = {{1,2},{2,3},{3,4}};
        System.out.println(arr.countPairs(intervals));
        
        int[][] intervals1 = {{1,5},{2,4},{3,6}};
        System.out.println(arr.countPairs(intervals1));
        
        int[][] intervals2 = {{1,2},{3,4},{5,6}};
        System.out.println(arr.countPairs(intervals2));
        
        int[][] intervals3 = {{97,100},{61,61}};
        System.out.println(arr.countPairs(intervals3));
    }
}