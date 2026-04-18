//Problem: https://leetcode.com/problems/find-the-key-of-the-numbers/description/





import java.io.*;
import java.util.*;


class KeyOfNumbers {
    public int generate(int num1, int num2, int num3) {
        String ans = "";
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        String s3 = String.valueOf(num3);
        int len = Math.max(s1.length(), Math.max(s2.length(), s3.length()));
        String str1 = appendZeroes(s1, len - s1.length());
        String str2 = appendZeroes(s2, len - s2.length());
        String str3 = appendZeroes(s3, len - s3.length());
        for(int i=0; i<len; i++) {
            int n = str1.charAt(i) - '0';
            int m = str2.charAt(i) - '0';
            int p = str3.charAt(i) - '0';
            int r = Math.min(n , Math.min(m, p));
            ans+=r;

        }
        return Integer.valueOf(ans);
    }

    public String appendZeroes(String s, int zero) {
        String ans = "";
        for(int i=0; i<zero; i++) {
            ans+="0";
        }
        ans+=s;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        KeyOfNumbers key = new KeyOfNumbers();
        System.out.println(key.generate(1, 10, 1000));
        System.out.println(key.generate(987, 879, 798));
        System.out.println(key.generate(1, 2, 3));
    }
}