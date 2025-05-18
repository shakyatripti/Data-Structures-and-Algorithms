//Problem: https://leetcode.com/problems/rotate-string/description/



import java.io.*;
import java.util.*;

class RotateTheString {
    public boolean rotated (String s, String goal) {
        if(s.length()!=goal.length()) {
            return false;
        }
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==goal.charAt(0)) {
                String str1 = s.substring(i, s.length());
                String str2 = s.substring(0, i);
                if(goal.equals(str1+str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        RotateTheString str = new RotateTheString();
        System.out.println(str.rotated("abcde", "cdeab"));
        System.out.println(str.rotated("abcde", "abced"));
        System.out.println(str.rotated("bbbacddceeb", "ceebbbbacdd"));
        System.out.println(str.rotated("gcmbf", "fcgmb"));
    }
}