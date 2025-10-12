//Problem: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/





import java.io.*;
import java.util.*;

class MaxWidthOfVerticalArea {
    public int maxWidth(int[][] points) {
        int width=0;
        Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0]));
        for(int i=0; i<points.length-1; i++) {
            width = Math.max(width, (points[i+1][0]-points[i][0]));
        }
        return width;
    }
}

class Main {
    public static void main(String[] args) {
        MaxWidthOfVerticalArea area = new MaxWidthOfVerticalArea();
        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        System.out.println(area.maxWidth(points));
        
        int[][] points1 = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        System.out.println(area.maxWidth(points1));
    }
}