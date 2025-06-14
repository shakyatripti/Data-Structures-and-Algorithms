//Problem: https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/



import java.io.*;
import java.util.*;

class RemappingDigits {
    public int minMaxDifference(int num) {
        int maxNum=0, minNum=0;
        String str = String.valueOf(num);
        minNum = (int) (str.charAt(0) - '0');
        for(char ch: str.toCharArray()) {
            int d1 = (int) (ch-'0');
            if(d1!=9) {
               maxNum = d1;
               break;
            }
        }
        String ans1 = replaceDigit(str, maxNum, 9);
        String ans2 = replaceDigit(str, minNum, 0);
        return Integer.parseInt(ans1) - Integer.parseInt(ans2);
        
    }

    public String replaceDigit(String str, int d1, int d2) {
        String ans="";
        for(char ch: str.toCharArray()) {
            int digit = (int) (ch-'0');
            if(digit==d1) {
               ans+=String.valueOf(d2);
            } else {
                ans+=ch;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        RemappingDigits digits = new RemappingDigits();
        System.out.println(digits.minMaxDifference(11891));
        System.out.println(digits.minMaxDifference(90));
        System.out.println(digits.minMaxDifference(3297));
    }
}