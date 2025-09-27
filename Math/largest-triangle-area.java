//Problem: https://leetcode.com/problems/largest-triangle-area/description/




import java.io.*;
import java.util.*;


class LargestTriangleArea {
    public double calculateArea(int[][] points) {
        double area=0;
        for(int i=0; i<points.length; i++) {  
            int x1=points[i][0], y1=points[i][1];
            for(int j=i+1; j < points.length; j++) {
                int x2=points[j][0], y2=points[j][1];
                for(int k=j+1; k<points.length; k++) {
                    int x3=points[k][0], y3=points[k][1];
                    double currArea = 0.5*Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
                    area=Math.max(currArea, area);      
                }
            }
        }
        return area;
    }
}


class Main { 
    public static void main(String[] args) {
        LargestTriangleArea triangle = new LargestTriangleArea();
        int[][] points = {{0,1}, {0,0},{1,0}, {0,2},{2,0}};
        System.out.println(triangle.calculateArea(points));
        
        int[][] points1 = {{1,0}, {0,0}, {0,1}};
        System.out.println(triangle.calculateArea(points1));
    }
}