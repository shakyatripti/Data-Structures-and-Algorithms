//Problem: https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/description/






import java.io.*;
import java.util.*;

class ReverseBinaryString {
    public int minimumFlips(int n) {
        int ans = 0;
        StringBuilder str = new StringBuilder("");
        while(n!=0) {
            int r = n%2;
            str.append(r);
            n=n/2;
        }
        String org = str.toString();
        str.reverse();
        String st = str.toString();
        for(int i=0; i<st.length(); i++) {
            if(st.charAt(i)!=org.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReverseBinaryString str = new ReverseBinaryString();
        System.out.println(str.minimumFlips(7));
        System.out.println(str.minimumFlips(10));
    }
}