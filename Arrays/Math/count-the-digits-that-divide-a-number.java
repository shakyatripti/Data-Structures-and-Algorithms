//Problem: https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/




import java.io.*;
import java.util.*;

class CountDigits {
    public int canDivide(int num) {
        int num1 = num, val=0;
        while(num!=0) {
            int r = num%10;
            num = num/10;
            if(num1%r==0) {
                val++;
            }
        }
        return val;
    }
}

class Main {
    public static void main(String[] args) {
        CountDigits digits = new CountDigits();
        System.out.println(digits.canDivide(6));
        System.out.println(digits.canDivide(121));
        System.out.println(digits.canDivide(1248));
    }
}