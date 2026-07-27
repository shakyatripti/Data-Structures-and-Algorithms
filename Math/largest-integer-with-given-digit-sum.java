//Problem: https://leetcode.com/problems/largest-integer-with-given-digit-sum/description/





import java.io.*;
import java.util.*;


class DigitSum {
    public int largestInteger(int n, int s) {
        int maxVal = (int) Math.pow(10, n);
        for(int i=maxVal-1; i>=0; i--) {
            int num = i, sum = 0;
            while(num!=0) {
                int r = num%10;
                num = num/10;
                sum+=r;
            }

            if(sum==s) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        DigitSum digit = new DigitSum();
        System.out.println(digit.largestInteger(2, 9));
        System.out.println(digit.largestInteger(2, 19));
        System.out.println(digit.largestInteger(5, 0));
    }
}