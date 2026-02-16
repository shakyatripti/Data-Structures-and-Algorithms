//Problem: https://leetcode.com/problems/lexicographically-smallest-palindrome/description/




import java.io.*;
import java.util.*;

class Palindrome {
    public String makeLexicographicallySmallest(String s) {
        StringBuilder str = new StringBuilder("");
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(s.charAt(i)!=s.charAt(n-1-i)) {
                int v1 = s.charAt(i) - 'a';
                int v2 = s.charAt(n-1-i) - 'a';
                if(v1 > v2) {
                    str.append(s.charAt(n-1-i));
                } else {
                    str.append(s.charAt(i));
                }
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString(); 
    }
}

class Main {
    public static void main(String[] args) {
        Palindrome str = new Palindrome();
        System.out.println(str.makeLexicographicallySmallest("egcfe"));
        System.out.println(str.makeLexicographicallySmallest("abcd"));
        System.out.println(str.makeLexicographicallySmallest("seven"));
    }
}