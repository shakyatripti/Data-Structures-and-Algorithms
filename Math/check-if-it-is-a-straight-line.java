//Problem: https://leetcode.com/problems/check-if-it-is-a-straight-line/description/




import java.io.*;
import java.util.*;

class StraightLine {
    public boolean check(int[][] coordinates) {
        int x1 = coordinates[0][0], x2 = coordinates[1][0], y1 = coordinates[0][1], y2 = coordinates[1][1];      
        int dx = x2-x1, dy = y2-y1;
        for(int i=2; i<coordinates.length; i++) {
            int x = coordinates[i][0] - x1;
            int y = coordinates[i][1] - y1;
            if(x*dy != y*dx) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public void main(String[] args) {
        StraightLine line = new StraightLine();
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(line.check(coordinates));
        
        int[][] coordinates1 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(line.check(coordinates1));
        
        int[][] coordinates2 = {{0,0},{0,1},{0,-1}};
        System.out.println(line.check(coordinates2));
        
        int[][] coordinates3 = {{1,1},{2,2},{2,0}};
        System.out.println(line.check(coordinates3));
        
        int[][] coordinates4 = {{-2,12},{2,-8},{6,-28},{-10,52},{-7,37},{4,-18},{7,-33},{1,-3},{-1,7},{8,-38}};
        System.out.println(line.check(coordinates4));
    }
}