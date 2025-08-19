//Problem: https://leetcode.com/problems/hash-divided-string/description/




import java.io.*;
import java.util.*;

class DividedString {
    public String stringHash(String s, int k) {
        String ans = "";
        int len=0, sum=0;
        for(int i=0; i<s.length(); i++) {
            if(len==k) {
                sum = sum%26;
                ans+=(char)(sum + 97);
                sum=0;
                len=0;
            }
            len++;
            sum+=s.charAt(i)-'a';
        }
        sum=sum%26;
        ans+=(char)(sum + 97);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        DividedString str = new DividedString();
        System.out.println(str.stringHash("abcd", 2));
        System.out.println(str.stringHash("mxz", 3));
        System.out.println(str.stringHash("a", 1));
        System.out.println(str.stringHash("ant", 1));
    }
}