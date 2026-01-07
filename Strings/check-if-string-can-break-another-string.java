//Problem: https://leetcode.com/problems/check-if-a-string-can-break-another-string/description/





import java.io.*;
import java.util.*;

class BreakString {
    public boolean check(String s1, String s2) {
        int flag=0, flag1=0;
        char[] str = new char[s1.length()];
        char[] str2 = new char[s2.length()];
        for(int i=0; i<s1.length(); i++) {
            str[i] = s1.charAt(i);
            str2[i] = s2.charAt(i);
        }

        Arrays.sort(str);
        Arrays.sort(str2);
        for(int i=0; i<s1.length(); i++) {
            if(str[i] < str2[i]) {
                flag++;
            } else if(str[i] > str2[i]) {
                flag1++;
            } else {
                flag++;
                flag1++;
            }
        }
        if(flag!=s1.length() && flag1!=s1.length()) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        BreakString str = new BreakString();
        System.out.println(str.check("abc", "xya"));
        System.out.println(str.check("abe", "acd"));
        System.out.println(str.check("leetcodee", "interview"));
        System.out.println(str.check("yopumzgd", "pamntyya"));
    }
}