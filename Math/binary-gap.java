//Problem: https://leetcode.com/problems/binary-gap/description/





import java.io.*;
import java.util.*;

class BinaryGap {
    public int findGap(int n) {
        int prev = -1, ans = 0;
        String str = "";
        while(n!=0) {
            int r = n%2;
            str+=r;
            n=n/2;
        }

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='1') {
                if(prev!=-1) {
                    ans = Math.max(ans, i-prev);
                }
                prev = i;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryGap binary = new BinaryGap();
        System.out.println(binary.findGap(22));
        System.out.println(binary.findGap(8));
        System.out.println(binary.findGap(5));
    }
}