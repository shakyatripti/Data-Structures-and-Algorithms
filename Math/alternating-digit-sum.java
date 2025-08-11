//Problem: https://leetcode.com/problems/alternating-digit-sum/description/




import java.io.*;
import java.util.*;

class AlternateDigitSum {
    public int digitSum(int n) {
        int sum = 0, flag = 0, m=0;
        while(n!=0) {
            int r = n%10;
            m=m*10 + r;
            n=n/10;
        }
        while(m!=0) {
            int r = m%10;
            if(flag==0) {
                sum+=r;
                flag=1;
            } else {
                sum-=r;
                flag=0;
            }
            m=m/10;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        AlternateDigitSum num = new AlternateDigitSum();
        System.out.println(num.digitSum(521));
        System.out.println(num.digitSum(111));
        System.out.println(num.digitSum(886996));
        System.out.println(num.digitSum(10));
        System.out.println(num.digitSum(998796214));
    }
}