//Problem: https://leetcode.com/problems/number-of-even-and-odd-bits/description/




import java.io.*;
import java.util.*;

class EvenOddBits {
    public int[] count(int n) {
        int[] ans = new int[2];
        int even=0, odd=0;
        StringBuilder str = new StringBuilder();
        while(n!=0) {
            int r = n%2;
            str.append(r);
            n = n/2;
        }
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='1') {
                if(i%2==0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        ans[0] = even;
        ans[1] = odd;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        EvenOddBits bits = new EvenOddBits();
        int[] ans = bits.count(50);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] ans1 = bits.count(2);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] ans2 = bits.count(5);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}