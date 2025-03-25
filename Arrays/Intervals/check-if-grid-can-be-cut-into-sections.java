//Problem: https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/

import java.io.*;
import java.util.*;

class CutGridIntoSections {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int r = rectangles.length;
        int[][] startIntervals = new int[r][2];
        int[][] endIntervals = new int[r][2];
        for(int i=0; i<r; i++) {
            startIntervals[i][0] = rectangles[i][0];
            startIntervals[i][1] = rectangles[i][2];
            endIntervals[i][0] = rectangles[i][1];
            endIntervals[i][1] = rectangles[i][3];
        }
        
        return mergeIntervals(startIntervals) > 2 || mergeIntervals(endIntervals) > 2;
    }
    
    public int mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));
        int[] prev = intervals[0];
        int count = 1;
        for(int i=1; i<intervals.length; i++) {
            if(prev[1] <= intervals[i][0]) {
                count++;
            }
            prev[1] = Math.max(prev[1], intervals[i][1]);
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] rectangles = {{0,0,1,1},{2,0,3,4},{0,2,2,3},{3,0,4,3}};
        CutGridIntoSections sections = new CutGridIntoSections();
        System.out.println(sections.checkValidCuts(4, rectangles));
        
        int[][] rectangles2 = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        System.out.println(sections.checkValidCuts(5, rectangles2));
        
        int[][] rectangles3 = {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};
        System.out.println(sections.checkValidCuts(4, rectangles3));
    }
}