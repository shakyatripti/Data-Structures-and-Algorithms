//Problem: https://leetcode.com/problems/merge-intervals/description/



import java.io.*;
import java.util.*;


class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y)-> Integer.compare(x[0], y[0]));
        ArrayList<int[]> arr = new ArrayList<int[]>();
        int[] prev = intervals[0];
        arr.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                arr.add(intervals[i]);
                prev = intervals[i];
            }
        }
        
        int[][] ans = new int[arr.size()][2];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        
        return ans;
    }
    
    public void display(int[][] ans) {
        for(int[] i: ans) {
            System.out.print("[" + i[0] + "," + i[1] + "]" + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{15,18},{8,10}};
        MergeIntervals result = new MergeIntervals();
        int[][] ans = result.merge(intervals);
        result.display(ans);
        
        int[][] intervals2 = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] ans2 = result.merge(intervals2);
        result.display(ans2);
    }
}