//Problem: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/



import java.io.*;
import java.util.*;

class EqualDigitCountAndValue {
    public boolean digitCount(String num) {
        int[] freq = new int[11];
        for(int i=0; i<num.length(); i++) {
            int ch = num.charAt(i) - '0';
            freq[ch]++;
        }
        for(int i=0; i<num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if(freq[i]!=digit) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        EqualDigitCountAndValue value = new EqualDigitCountAndValue();
        System.out.println(value.digitCount("1210"));
        
        System.out.println(value.digitCount("030"));
        
        System.out.println(value.digitCount("4213"));
    }
}