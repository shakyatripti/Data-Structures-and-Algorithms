//Problem: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/description/




import java.io.*;
import java.util.*;


class ABeforeB {
    public boolean checkString(String s) {
        int a=-1, b=-1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='a') {
                a=i;
            }
            if(ch=='b' && b==-1) {
                b=i;
            }
        }
        if(b!=-1 && b < a) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ABeforeB str = new ABeforeB();
        System.out.println(str.checkString("aaabbb"));
        System.out.println(str.checkString("abab"));
        System.out.println(str.checkString("bbb"));
        System.out.println(str.checkString("a"));
    }
}