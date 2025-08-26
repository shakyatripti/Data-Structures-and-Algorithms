//Problem: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/




import java.io.*;
import java.util.*;

class LongestDiagonal {
    public int maxArea(int[][] dimensions) {
        int area = 0;
        double diagonal = 0, maxLength=0;
        for(int i=0; i<dimensions.length; i++) {
            int length=dimensions[i][0], width=dimensions[i][1];
            diagonal = Math.sqrt((length*length) + (width*width));
            if(diagonal==maxLength) {
                maxLength = diagonal;
                area = Math.max(area, length*width);
            }
            if(diagonal > maxLength) {
                maxLength = diagonal;
                area=length*width;
            }
        }
        return area;
    }
}

class Main {
    public static void main(String[] args) {
        LongestDiagonal rectangle = new LongestDiagonal();
        int[][] dimensions = {{9,3},{8,6}};
        System.out.println(rectangle.maxArea(dimensions));
        
        int[][] dimensions1 = {{3,4},{4,3}};
        System.out.println(rectangle.maxArea(dimensions1));
        
        int[][] dimensions2 = {{6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}};
        System.out.println(rectangle.maxArea(dimensions2));
    }
}