//Problem: https://leetcode.com/problems/maximum-height-of-a-triangle/description/




import java.io.*;
import java.util.*;

class Triangle {
    public int maxHeight(int red, int blue) {
        int h1 = calcHeight(red, blue);
        int h2 = calcHeight(blue, red);
        return Math.max(h1, h2);
    }

    public int calcHeight(int start, int next) {
        int height = 0, counter = 1;
        while(start >= counter && next >= counter) {
            if(counter%2!=0) {
                start-=counter;
            } else {
                next-=counter;
            }
            counter++;
            height++;
        }
        if(counter%2==0 && next>=counter) {
            height++;
        }
        if(counter%2!=0 && start>=counter) {
            height++;
        }
        return height;
    }
}

class Main {
    public static void main(String[] args) {
        Triangle row = new Triangle();
        System.out.println(row.maxHeight(2,4));
        System.out.println(row.maxHeight(2,1));
        System.out.println(row.maxHeight(1,1));
        System.out.println(row.maxHeight(10,1));
    }
}