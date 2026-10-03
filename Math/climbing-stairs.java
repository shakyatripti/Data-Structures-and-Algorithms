//Problem: https://leetcode.com/problems/climbing-stairs/description/





import java.io.*;
import java.util.*;


class ClimbStairs {
    public int countDistinctWays(int n) {
        int p1=1, p2=2, sum=0;
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        for(int i=3; i<=n; i++) {
            sum = p1 + p2;
            p1 = p2;
            p2 = sum;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
        System.out.println(stairs.countDistinctWays(2));
        System.out.println(stairs.countDistinctWays(3));
        System.out.println(stairs.countDistinctWays(5));
        System.out.println(stairs.countDistinctWays(42));
    }
}