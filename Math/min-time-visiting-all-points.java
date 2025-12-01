//Problem: https://leetcode.com/problems/minimum-time-visiting-all-points/description/




import java.io.*;
import java.util.*;

class VisitAllPoints {
    public int minTime(int[][] points) {
        int time = 0;
        for(int i=0; i<points.length-1; i++) {
            int x = Math.abs(points[i+1][0]-points[i][0]);
            int y = Math.abs(points[i+1][1]-points[i][1]);
            time+=Math.max(x,y);
        }
        return time;
    }
}

class Main {
    public static void main(String[] args) {
        VisitAllPoints plane = new VisitAllPoints();
        int[][] points = {{1,1},{3,4},{-1,0}};
        System.out.println(plane.minTime(points));
        
        int[][] points1 = {{3,2},{-2,2}};
        System.out.println(plane.minTime(points1));
    }
}