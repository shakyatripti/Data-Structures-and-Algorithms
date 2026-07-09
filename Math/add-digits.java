//Problem: https://leetcode.com/problems/add-digits/description/



import java.io.*;
import java.util.*;


class AddDigits {
    public int isSingle(int num) {
        int n = num;
        while(n>9) {
            int sum = 0;
            while(n!=0) {
                int r = n%10;
                sum+=r;
                n=n/10;
            }
            n = sum;
        }
        return n;
    }
}

class Main {
    public static void main(String[] args) {
        AddDigits digit = new AddDigits();
        System.out.println(digit.isSingle(38));
        System.out.println(digit.isSingle(0));
    }
}