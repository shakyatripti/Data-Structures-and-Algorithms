//Problem: https://leetcode.com/problems/find-the-original-typed-string-i/description/




import java.io.*;
import java.util.*;

class OriginalTypedString {
    public int possibleString(String word) {
        int ans=1, l=0, r=1;
        while(l<word.length() && r<word.length()) {
            if(word.charAt(l)!=word.charAt(r)) {
                ans+=r-l-1;
                l=r;
                r++;
            } else {
                r++;
            }
        }
        if(r==word.length()) {
            ans+=r-l-1;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        OriginalTypedString str = new OriginalTypedString();
        System.out.println(str.possibleString("abbcccc"));
        System.out.println(str.possibleString("eettee"));
        System.out.println(str.possibleString("abcd"));
        System.out.println(str.possibleString("bcxdsdddef"));
        System.out.println(str.possibleString("aaaa"));
    }
}