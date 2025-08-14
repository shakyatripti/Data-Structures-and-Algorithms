//Problem: https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/




import java.io.*;
import java.util.*;

class LargestNumber {
    public String goodInteger(String num) {
        String ans="-";
        int maxVal = 0;
        for(int i=0; i<=num.length()-3; i++) {
            String substr = num.substring(i, i+3);
            int val = Integer.valueOf(substr);
            if(val >= maxVal && substr.length()==3) {
                if(substr.charAt(0)==substr.charAt(1) && substr.charAt(1)==substr.charAt(2)) {
                   maxVal = val;
                   ans = substr;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.goodInteger("6777133339"));
        System.out.println(obj.goodInteger("222"));
        System.out.println(obj.goodInteger("2300019"));
        System.out.println(obj.goodInteger("42352338"));
    }
}