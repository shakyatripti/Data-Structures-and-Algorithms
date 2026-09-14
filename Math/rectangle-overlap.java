//Problem: https://leetcode.com/problems/rectangle-overlap/description/




import java.io.*;
import java.util.*;


class Rectangle {
    public boolean isOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];
        if(x1 < x4 && x2 > x3 && y1 < y4 && y2 > y3) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Rectangle num = new Rectangle();
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        System.out.println(num.isOverlap(rec1, rec2));
        
        int[] rec3 = {0,0,1,1};
        int[] rec4 = {1,0,2,1};
        System.out.println(num.isOverlap(rec3, rec4));
        
        int[] rec5 = {0,0,1,1};
        int[] rec6 = {2,2,3,3};
        System.out.println(num.isOverlap(rec5, rec6));
        
    }
}