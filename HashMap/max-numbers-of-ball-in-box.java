//Problem: https://leetcode.com/problems/maximum-number-of-balls-in-a-box/description/




import java.io.*;
import java.util.*;

class MaxBallsInBox {
    public int countBalls(int lowLimit, int highLimit) {
        int ans=0;
        int[] freq = new int[100];
        for(int i=lowLimit; i<=highLimit; i++) {
            int boxCount = digitSum(i);
            freq[boxCount]++;
            ans = Math.max(ans, freq[boxCount]);
        }
        return ans;
    }
    
    public int digitSum(int num) {
        int sum=0;
        while(num!=0) {
            int r = num % 10;
            num = num / 10;
            sum+=r;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        MaxBallsInBox box = new MaxBallsInBox();
        System.out.println(box.countBalls(1, 10));
        System.out.println(box.countBalls(3, 25));
        System.out.println(box.countBalls(19, 28));
    }
}