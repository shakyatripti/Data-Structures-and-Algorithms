//Problem: https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/description/




import java.io.*;
import java.util.*;

class CompatibleNumInRangeI {
    public int sumOfNumbers(int n, int k) {
        int end = k + n, sum = 0;
        for(int x=0; x<=end; x++) {
            if(Math.abs(n-x)<=k && (n & x)==0) {
                sum+=x;
            }
        }
        return sum;
    }
}

class Main {
    public void main(String[] args) {
        CompatibleNumInRangeI num = new CompatibleNumInRangeI();
        System.out.println(num.sumOfNumbers(2, 3));
        System.out.println(num.sumOfNumbers(5, 1));
    }
}