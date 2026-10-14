//Problem: https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/




import java.io.*;
import java.util.*;


class DigitSumOfString {
    public String calculate(String s, int k) {
        while(s.length() > k) {
            int curr = 0;
            String ans = "";
            while(curr < s.length()) {
                String substr = "";
                if(curr+k >= s.length()) {
                    substr = s.substring(curr, s.length());
                } else {
                    substr = s.substring(curr, curr+k);
                }
                ans+=findSum(substr);
                curr = curr+k;
            }
            s=ans;
        }
        return s;
    }

    public String findSum(String str) {
        int total = 0;
        for(int i=0; i<str.length(); i++) {
            int val = (int) (str.charAt(i) - '0');
            total+=val;
        }
        return String.valueOf(total);
    }
}

class Main {
    public static void main(String[] args) {
        DigitSumOfString str = new DigitSumOfString();
        System.out.println(str.calculate("11111222223", 3));
        System.out.println(str.calculate("00000000", 3));
        System.out.println(str.calculate("1", 2));
    }
}