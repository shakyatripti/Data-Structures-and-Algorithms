//Problem: https://leetcode.com/problems/valid-boomerang/description 




import java.io.*;
import java.util.*;


class Boomerang {
    public boolean isValid(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        if((x1==x2 && y1==y2) || (x1==x3 && y1==y3) || (x2==x3 && y2==y3)) {
            return false;
        }
        if((y2-y1)*(x3-x2)==(y3-y2)*(x2-x1)) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Boomerang plane = new Boomerang();
        int[][] points = {{1,1}, {2,3}, {3,2}};
        System.out.println(plane.isValid(points));
        
        int[][] points1 = {{1,1}, {2,2}, {3,3}};
        System.out.println(plane.isValid(points1));
    }
}