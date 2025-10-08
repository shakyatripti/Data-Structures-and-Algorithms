//Problem: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/




import java.io.*;
import java.util.*;


class ConvertNumber {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        String num = convertToBinary(start);
        String num1 = convertToBinary(goal);
        if(num.length() > num1.length()) {
            int n=num1.length();
            for(int i=0; i<num.length() - n; i++) {
                num1+="0";
            }
        }
        if(num.length() < num1.length()) {
            int n=num.length();
            for(int i=0; i<num1.length() - n; i++) {
                num+="0";
            }
        }

        for(int i=0; i<num.length(); i++) {
            if(num.charAt(i)!=num1.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public String convertToBinary(int n) {
        StringBuilder ans = new StringBuilder();
        while(n!=0) {
            int r=n%2;
            n=n/2;
            ans.append(r);
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        ConvertNumber num = new ConvertNumber();
        System.out.println(num.minBitFlips(10, 7));
        System.out.println(num.minBitFlips(3,4));
        System.out.println(num.minBitFlips(99, 29));
    }
}

