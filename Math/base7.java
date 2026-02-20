//Problem: https://leetcode.com/problems/base-7/description/




import java.io.*;
import java.util.*;

class Base7 {
    public String convert(int num) {
        if(num==0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder("");
        int n = Math.abs(num);
        while(n!=0) {
            int r = n%7;
            ans.append(r);
            n = n/7;
        }
        if(num < 0) {
            ans.append("-");
        }
        ans.reverse();
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Base7 base = new Base7();
        System.out.println(base.convert(100));
        System.out.println(base.convert(-7));
        System.out.println(base.convert(0));
    }
}