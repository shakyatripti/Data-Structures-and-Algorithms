//Problem: https://leetcode.com/problems/maximum-odd-binary-number/description/





import java.util.*;
import java.io.*;

class MaxOddBinaryNumber {
    public String findMax(String s) {
        StringBuilder ans = new StringBuilder();
        int zeroes=0, ones=0;
        for(char ch: s.toCharArray()) {
            if(ch=='0') {
                zeroes++;
            } else {
                ones++;
            }
        }
        for(int i=0; i<ones-1; i++) {
            ans.append(1);
        }
        for(int i=0; i<zeroes; i++) {
            ans.append(0);
        }
        if(ones!=0) {
            ans.append(1);
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        MaxOddBinaryNumber num = new MaxOddBinaryNumber();
        System.out.println(num.findMax("010"));
        System.out.println(num.findMax("0101"));
    }
}