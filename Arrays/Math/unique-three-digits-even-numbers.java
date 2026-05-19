//Problem: https://leetcode.com/problems/unique-3-digit-even-numbers/description/



import java.io.*;
import java.util.*;

class ThreeDigitEvenNum {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer> ans = new HashSet<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(i==j) {
                        continue;
                    }
                    if(k==j || k==i) {
                        continue;
                    }
                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    if(num >= 100 && num<=999 && num%2==0) {
                        ans.add(num);
                    }
                }
            }
        }
        return ans.size();
    }
}

class Main {
    public static void main(String[] args) {
        ThreeDigitEvenNum num = new ThreeDigitEvenNum();
        int[] digits = {1,2,3,4};
        System.out.println(num.totalNumbers(digits));
        
        int[] digits1 = {0,2,2};
        System.out.println(num.totalNumbers(digits1));
        
        int[] digits2 = {6,6,6};
        System.out.println(num.totalNumbers(digits2));
        
        int[] digits3 = {1,3,5};
        System.out.println(num.totalNumbers(digits3));
    }
}