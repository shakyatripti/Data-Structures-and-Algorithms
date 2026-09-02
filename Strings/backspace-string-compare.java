//Problem: https://leetcode.com/problems/backspace-string-compare/description/




import java.io.*;
import java.util.*;


class BackspaceString {
    public boolean compare(String s, String t) {
        String ans1 = finalString(s);
        String ans2 = finalString(t);
        if(ans1.equals(ans2)) {
            return true;
        }
        return false;
    }

    public String finalString(String s) {
        StringBuilder str = new StringBuilder("");
        for(char ch: s.toCharArray()) {
            if(ch=='#' && str.length() > 0) {
                str.deleteCharAt(str.length()-1);
            }
            if(ch!='#') {
                str.append(ch);
            }
        }
        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        BackspaceString str = new BackspaceString();
        System.out.println(str.compare("ab#c", "ad#c"));
        System.out.println(str.compare("ab##", "c#d#"));
        System.out.println(str.compare("a#c", "b"));
        System.out.println(str.compare("a##c", "#a#c"));
        System.out.println(str.compare("y#fo##f", "y#f#o##f"));
    }
}