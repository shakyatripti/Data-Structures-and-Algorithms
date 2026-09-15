//Problem:
https://leetcode.com/problems/construct-the-rectangle/description/




import java.io.*;
import java.util.*;

class Rectangle {
    public int[] construct(int area) {
        int root = (int) Math.sqrt(area);
        int[] ans = new int[2];
        int diff = Integer.MAX_VALUE;
        for(int i=root; i>=1; i--) {
            if(area%i==0) { 
                int val = area/i;
                int curr = Math.abs(val - i);
                if(diff > curr) {
                    ans[0] = val;
                    ans[1] = i;
                    diff = curr;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Rectangle page = new Rectangle();
        int[] ans = page.construct(4);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] ans1 = page.construct(37);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] ans2 = page.construct(122122);
        System.out.println(ans2[0] + " " + ans2[1]);
        

    }
}