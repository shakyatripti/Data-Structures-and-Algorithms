//Problem: https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/





import java.io.*;
import java.util.*;


class BeautifulSubstring {
    public String findShortest(String s, int k) {
        String ans = "";
        int n=s.length(), len=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int one=0;
            for(int j=i; j<n; j++) {
                int curr = j-i+1;
                String substr = s.substring(i, j+1);
                if(s.charAt(j)=='1') {
                    one++;
                }

                if(one==k && len==curr) {
                    ans = isLexoSmall(ans, substr);
                }

                if(one==k && len > curr) {
                    ans = substr;
                    len = curr;
                }
            }
        }
        return ans=="" ? "--" : ans;
    }

    public String isLexoSmall(String s1, String s2) {
        int n=s1.length();
        for(int i=0; i<n; i++) {
            if(s1.charAt(i) > s2.charAt(i)) {
                return s2;
            } else if(s1.charAt(i) < s2.charAt(i)) {
                return s1;
            }
        }
        return s1;
    }
}

class Main {
    public static void main(String[] args) {
        BeautifulSubstring str = new BeautifulSubstring();
        System.out.println(str.findShortest("100011001", 3));
        System.out.println(str.findShortest("1011", 2));
        System.out.println(str.findShortest("000", 1));
        System.out.println(str.findShortest("001110101101101111", 10));
        System.out.println(str.findShortest("110101000010110101", 3));
    }
}