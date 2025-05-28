//Problem: https://leetcode.com/problems/assign-cookies/description/



import java.io.*;
import java.util.*;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0, r=0, count =0;
        while(l<g.length && r<s.length) {
            if(s[r]>=g[l]) {
                l++;
                count++;
            }
            r++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        AssignCookies cookies = new AssignCookies();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(cookies.findContentChildren(g,s));
        
        int[] g1 = {1,2};
        int[] s1 = {1,2,3};
        System.out.println(cookies.findContentChildren(g1,s1));
    }
}