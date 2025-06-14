//Problem: https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/description/




import java.io.*;
import java.util.*;

class RemoveDigit {
    public String maxResult(String number, char digit) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=0; i<number.length(); i++) {
            char ch = number.charAt(i);
            if(ch==digit) {
                StringBuilder str = new StringBuilder(number);
                str.deleteCharAt(i);
                if(str.compareTo(sb) > 0) {
                    sb = str;
                }
            }
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        RemoveDigit digit = new RemoveDigit();
        System.out.println(digit.maxResult("123", '3'));
        System.out.println(digit.maxResult("2998589353917872714814599237991174513476623756", '6'));
        System.out.println(digit.maxResult("551", '5'));
    }
}