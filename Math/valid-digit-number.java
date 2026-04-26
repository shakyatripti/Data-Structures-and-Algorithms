//Problem: https://leetcode.com/problems/valid-digit-number/description/





import java.io.*;
import java.util.*;


class ValidDigit {
    public boolean isValid (int n, int x) {
        int count = 0;
        while(n!=0) {
            int r = n%10;
            if(r==x) {
                count++;
            }
            if((n/10)==0 && r==x) {
                return false;
            }
            n = n/10;
        }
        if(count < 1) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ValidDigit digit = new ValidDigit();
        System.out.println(digit.isValid(101, 0));
        System.out.println(digit.isValid(232, 2));
        System.out.println(digit.isValid(5, 1));
    }
}