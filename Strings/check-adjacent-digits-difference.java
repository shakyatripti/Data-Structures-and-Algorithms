//Problem: https://leetcode.com/problems/check-adjacent-digit-differences/description





import java.io.*;
import java.util.*;

class AdjacentDigits {
    public boolean isDiffAtMostTwo(String s) {
        int n=s.length();
        for(int i=0; i<n-1; i++) {
            int first = s.charAt(i) - '0';
            int second = s.charAt(i+1) - '0';
            if(Math.abs(first-second)> 2) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        AdjacentDigits digits = new AdjacentDigits();
        System.out.println(digits.isDiffAtMostTwo("132"));
        System.out.println(digits.isDiffAtMostTwo("129"));
    }
}