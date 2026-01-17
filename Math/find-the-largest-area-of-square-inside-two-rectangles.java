//Problem: https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/description/





import java.io.*;
import java.util.*;

class SquareInside {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n=bottomLeft.length, maxSide = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int x2 = Math.min(topRight[i][0], topRight[j][0]);
                int y2 = Math.min(topRight[i][1], topRight[j][1]);

                int width = x2-x1, height = y2-y1;
                int side = Math.min(width, height);
                maxSide = Math.max(side, maxSide);
            }
        }
        return (long) maxSide * maxSide;
    }
}

class Main {
    public static void main(String[] args) {
        SquareInside sq = new SquareInside();
        int[][] bottomLeft = {{1,1},{2,2},{3,1}};
        int[][] topRight = {{3,3},{4,4},{6,6}};
        System.out.println(sq.largestSquareArea(bottomLeft, topRight));
        
        int[][] bottomLeft1 = {{1,1},{1,3},{1,5}};
        int[][] topRight1 = {{5,5},{5,7},{5,9}};
        System.out.println(sq.largestSquareArea(bottomLeft1, topRight1));
        
        int[][] bottomLeft2 = {{1,1},{2,2},{1,2}};
        int[][] topRight2 = {{3,3},{4,4},{3,4}};
        System.out.println(sq.largestSquareArea(bottomLeft2, topRight2));
        
        int[][] bottomLeft3 = {{1,1},{3,3},{3,1}};
        int[][] topRight3 = {{2,2},{4,4},{4,2}};
        System.out.println(sq.largestSquareArea(bottomLeft3, topRight3));
    }
}