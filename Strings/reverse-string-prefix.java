//Problem: https://leetcode.com/problems/reverse-string-prefix/description/



import java.io.*;
import java.util.*;

class ReversePrefix {
    public String reverse(String s, int k) {
        StringBuilder str = new StringBuilder();
        int i=0;
        while(k!=0) {
            str.append(s.charAt(i));
            i++;
            k--;
        }
        str.reverse();
        String ans = str.toString();
        while(i < s.length()) {
            ans+=s.charAt(i);
            i++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReversePrefix str = new ReversePrefix();
        System.out.println(str.reverse("abcd", 2));
        System.out.println(str.reverse("xyz", 3));
        System.out.println(str.reverse("hey", 1));
    }
}