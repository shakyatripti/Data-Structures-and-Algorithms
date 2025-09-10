//Problem: https://leetcode.com/problems/strictly-palindromic-number/description/




import java.io.*;
import java.util.*;

class StrictlyPalindromic {
    public boolean isPalindromic(int n) {
        for(int i=2; i<=n-2; i++) {
            int temp = n;
            StringBuilder digit = new StringBuilder();
            while(temp!=0) {
                int r = temp%i;
                digit.append(r);
                temp=temp/i;
            }  
            StringBuilder original = new StringBuilder(digit);
            if(digit.reverse()!=original) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        StrictlyPalindromic num = new StrictlyPalindromic();
        System.out.println(num.isPalindromic(9));
        System.out.println(num.isPalindromic(4));
        System.out.println(num.isPalindromic(6));
    }
}
