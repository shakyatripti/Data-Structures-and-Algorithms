//Problem: https://leetcode.com/problems/process-string-with-special-operations-i/description/




import java.io.*;
import java.util.*;

class ProcessString {
    public String specialOperations(String s) {
        StringBuilder ans = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch=='#') {
                ans.append(ans);
            } else if(ch=='%') {
               ans.reverse();
            } else if(ch=='*') {
                if(ans.length()-1 >= 0) {
                   ans.deleteCharAt(ans.length()-1);
                }
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        ProcessString str = new ProcessString();
        System.out.println(str.specialOperations("a#b%*"));
        System.out.println(str.specialOperations("z*#")=="" ? "-" : "");
        System.out.println(str.specialOperations("#cgd***vfd**%%"));
        System.out.println(str.specialOperations("%#abc*%##***dd%"));
    }
}