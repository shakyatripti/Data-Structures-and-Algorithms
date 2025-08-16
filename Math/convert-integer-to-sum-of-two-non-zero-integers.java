//Problem: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/




import java.io.*;
import java.util.*;

class ConvertInteger {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int a=1, b=n-a;
        while(containsZero(a) || containsZero(b)) {
            a++;
            b=n-a;
        }
        ans[0] = a;
        ans[1] = b;
        return ans;
    }

    public boolean containsZero(int n) {
        while(n!=0) {
            int r = n%10;
            if(r==0) {
                return true;
            }
            n=n/10;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ConvertInteger num = new ConvertInteger();
        int[] ans = num.getNoZeroIntegers(2);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] ans1 = num.getNoZeroIntegers(11);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] ans2 = num.getNoZeroIntegers(1010);
        System.out.println(ans2[0] + " " + ans2[1]);
        
        int[] ans3 = num.getNoZeroIntegers(201);
        System.out.println(ans3[0] + " " + ans3[1]);
    }
}