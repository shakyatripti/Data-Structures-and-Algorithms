//Problem: https://leetcode.com/problems/split-a-string-in-balanced-strings/description




import java.io.*;
import java.util.*;

class BalancedStrings {
    public int split(String s) {
        int l=0, r=0, ans=0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='R') {
                r++;
            }
            if(ch=='L') {
                l++;
            }
            if(r==l) {
               ans++;
               l=0;
               r=0;
            }
        }
        return ans;
    } 
}


class Main {
    public static void main(String[] args) {
        BalancedStrings str = new BalancedStrings();
        System.out.println(str.split("RLRRLLRLRL"));
        System.out.println(str.split("RLRRRLLRLL"));
        System.out.println(str.split("LLLLRRRR"));
    }
}