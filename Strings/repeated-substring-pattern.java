//Problem: https://leetcode.com/problems/repeated-substring-pattern/description/



import java.io.*;
import java.util.*;


class Substring {
    public boolean repeatedPattern(String s) {
        int n=s.length();
        for(int i=0; i<n-1; i++) {
            String str = s.substring(0, i+1);
            String ans = "";
            int m = str.length();
            for(int j=0; j<=n-m; j+=m) {
                ans+=str;
            }
            if(ans.equals(s)) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Substring str = new Substring();
        System.out.println(str.repeatedPattern("abab"));
        System.out.println(str.repeatedPattern("aba"));
        System.out.println(str.repeatedPattern("abcabcabcabc"));
    }
}