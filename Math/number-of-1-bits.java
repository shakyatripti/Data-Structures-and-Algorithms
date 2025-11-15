//Problem: https://leetcode.com/problems/number-of-1-bits/description/




import java.io.*;
import java.util.*;

class NumberOfSetBits {
    public int hammingWeight(int n) {
        int setBits = 0;
        while(n!=0) {
            int r=n%2;
            if(r==1) {
                setBits++;
            }
            n=n/2;
        }
        return setBits;
    }
}

class Main {
    public static void main(String[] args) {
        NumberOfSetBits num = new NumberOfSetBits();
        System.out.println(num.hammingWeight(11));
        System.out.println(num.hammingWeight(128));
        System.out.println(num.hammingWeight(2147483645));
    }
}