//Problem: https://leetcode.com/problems/minimum-rotations-to-dial-a-number-i/description/




import java.io.*;
import java.util.*;


class DialNumberI {
    public int minRotations(String s) {
        int total = 0, start = 0, end = 0, forwardSteps = 0, reverseSteps = 0;
        for(int i=0; i<s.length(); i++) {
            end = s.charAt(i) - '0';
            forwardSteps = Math.abs(start - end);
            reverseSteps = 10 - forwardSteps;
            total+=Math.min(forwardSteps, reverseSteps);
            start = s.charAt(i) - '0';
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        DialNumberI num = new DialNumberI();
        System.out.println(num.minRotations("0192837465"));
        System.out.println(num.minRotations("1200210200"));
    }
}