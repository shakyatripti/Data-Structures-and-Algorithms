//Problem: https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/description/




import java.io.*;
import java.util.*;

class PointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int count = 0;
            for(int j=0; j<points.length; j++) {
                int x1 = points[j][0], x2 = queries[i][0];
                int y1 = points[j][1], y2 = queries[i][1];
                int x3 = (x2-x1) * (x2-x1), y3 = (y2-y1) * (y2-y1);
                double dist = Math.sqrt(x3 + y3);
                if(dist <= queries[i][2]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        PointsInsideCircle circle = new PointsInsideCircle();
        int[][] points = {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};
        int[] ans = circle.countPoints(points, queries);
        circle.display(ans);
        
        int[][] points1 = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int[][] queries1 = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
        int[] ans1 = circle.countPoints(points1, queries1);
        circle.display(ans1);
    }
}