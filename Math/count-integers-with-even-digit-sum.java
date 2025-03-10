//Problem: https://leetcode.com/problems/count-integers-with-even-digit-sum/description/


import java.io.*;
import java.util.*;

class EvenSumDigits {
    public int countEvenSumIntegers(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(sumOfDigits(i)%2==0) {
                count++;
            }
        }
        return count;
    }
    
    public int sumOfDigits(int n) {
        int sum = 0;
        while(n!=0) {
            int r = n%10;
            n=n/10;
            sum+=r;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        EvenSumDigits digits = new EvenSumDigits();
        System.out.println(digits.countEvenSumIntegers(30));
        System.out.println(digits.countEvenSumIntegers(7));
    }
}