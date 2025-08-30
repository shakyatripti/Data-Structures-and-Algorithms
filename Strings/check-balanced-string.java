//Problem: https://leetcode.com/problems/check-balanced-string/description/




import java.io.*;
import java.util.*;

class BalancedStrings {
    public boolean isBalanced(String num) {
        int evenSum = 0, oddSum = 0;
        for(int i=0; i<num.length(); i++) {
            int val = num.charAt(i) - '0';
            if(i%2==0) {
                evenSum+=val;
            } else {
                oddSum+=val;
            }
        }
        if(evenSum==oddSum) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        BalancedStrings str = new BalancedStrings();
        System.out.println(str.isBalanced("1234"));
        System.out.println(str.isBalanced("24123"));
    }
}