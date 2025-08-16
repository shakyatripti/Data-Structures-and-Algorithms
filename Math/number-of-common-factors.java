//Problem: https://leetcode.com/problems/number-of-common-factors/description/




import java.io.*;
import java.util.*;

class CommonFactors {
    public int count(int a, int b) {
        int factors = 0;
        int minVal = Math.min(a,b);
        for(int i=1; i<=minVal; i++) {
            if(a%i==0 && b%i==0) {
                factors++;
            }
        }
        return factors;
    }
}

class Main {
    public static void main(String[] args) {
        CommonFactors factors = new CommonFactors();
        System.out.println(factors.count(12, 6));
        System.out.println(factors.count(25, 30));
        System.out.println(factors.count(8, 356));
    }
}