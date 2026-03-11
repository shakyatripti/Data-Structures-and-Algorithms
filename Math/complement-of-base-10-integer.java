//Problem: https://leetcode.com/problems/complement-of-base-10-integer/



import java.io.*;
import java.util.*;

class Base10Integer {
    public int bitwiseComplement(int n) {
        if(n==0) {
            return 1;
        }
        String s = "";
        int ans=0;
        while(n!=0) {
            int r = n%2;
            s+=r;
            n=n/2;
        }

        int p = s.length()-1;
        for(int i=p; i>=0; i--) {
            int val = 0;
            if(s.charAt(i)=='1') {
                val = 0;
            } else {
                val = 1;
            }
            ans+=val * Math.pow(2, p);
            p--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Base10Integer sol = new Base10Integer();

        System.out.println(sol.bitwiseComplement(5));
        System.out.println(sol.bitwiseComplement(7));
        System.out.println(sol.bitwiseComplement(10));
        System.out.println(sol.bitwiseComplement(0));
    }
}