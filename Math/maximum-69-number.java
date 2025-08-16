//Problem: https://leetcode.com/problems/maximum-69-number/description/



import java.io.*;
import java.util.*;

class Max69Number {
    public int maximum(int num) {
        String ans = String.valueOf(num);
        String res="";
        int flag=0;
        for(char ch: ans.toCharArray()) {
            int n = ch - '0';
            if(n==6 && flag==0) {
               res+='9';
               flag=1;
            } else {
               res+=ch;
            }
        }
        return Integer.valueOf(res);
    }
}

class Main {
    public static void main(String[] args) {
        Max69Number obj = new Max69Number();
        System.out.println(obj.maximum(9669));
        System.out.println(obj.maximum(996));
        System.out.println(obj.maximum(99));
    }
}