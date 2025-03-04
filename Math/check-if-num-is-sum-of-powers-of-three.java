//Problem: https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/


import java.io.*;
import java.util.*;

class SumOfPowerOfThree {
    public boolean checkPowersOfThree(int n) {
        while(n!=0) {
            int r = n%3;
            if(r==2) {
                return false;
            }
            n = n/3;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SumOfPowerOfThree sum = new SumOfPowerOfThree();
        System.out.println(sum.checkPowersOfThree(21));
        System.out.println(sum.checkPowersOfThree(12));
        System.out.println(sum.checkPowersOfThree(91));
    }
}