//Problem: https://leetcode.com/problems/reverse-bits/description/




import java.io.*;
import java.util.*;

class ReverseBits {
    public int reverse(int n) {
        String num = "";
        while(n!=0) {
            int r = n%2;
            num+=r;
            n=n/2;
        }
        int len =  31, ans = 0;
        for(char ch: num.toCharArray()) {
            int p = (int) Math.pow(2, len);
            ans+=p * (ch-'0');
            len--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReverseBits bits = new ReverseBits();
        System.out.println(bits.reverse(43261596));
        System.out.println(bits.reverse(2147483644));
    }
}