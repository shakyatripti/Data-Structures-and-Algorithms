//Problem: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/



import java.io.*;
import java.util.*;

class SumsDifference {
    public int divSum(int n, int m) {
        int num1=0, num2=0;
        for(int i=1;i<=n;i++) {
            if(i%m==0) {
                num2+=i;
            }else {
                num1+=i;
            }
        }
        return num1-num2;
    }
}

class Main {
    public static void main(String[] args) {
        SumsDifference diff = new SumsDifference();
        System.out.println(diff.divSum(10,3));
        System.out.println(diff.divSum(5,1));
        System.out.println(diff.divSum(5,6));
    }
    
}