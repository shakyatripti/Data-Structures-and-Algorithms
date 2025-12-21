//Problem: https://leetcode.com/problems/mirror-distance-of-an-integer/description/




import java.io.*;
import java.util.*;

class MirrorDistance {
    public int findDist(int n) {
        String ans = "";
        int m=n;
        while(m!=0) {
            int r = m%10;
            ans+=r;
            m=m/10;
        }
        int rev= Integer.valueOf(ans);
        return Math.abs(n-rev);
    }
}

class Main {
    public static void main(String[] args) {
        MirrorDistance arr = new MirrorDistance();
        System.out.println(arr.findDist(25));
        System.out.println(arr.findDist(10));
        System.out.println(arr.findDist(7));
    }
}