//Problem: https://leetcode.com/problems/reverse-string/description/



import java.io.*;
import java.util.*;

class ReverseString {
    public void reverse(char[] s) {
        int l=0, r=s.length-1;
        while(l<r) {
            char ch = s[l];
            s[l] = s[r];
            s[r] = ch;
            l++;
            r--;
        }
    }
    
    public void display(char[] s) {
        for(int i=0; i<s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ReverseString str = new ReverseString();
        char[] s = {'h','e','l','l','o'};
        str.reverse(s);
        str.display(s);
        
        char[] s1 = {'H','a','n','n','a','h'};
        str.reverse(s1);
        str.display(s1);
        
    }
}