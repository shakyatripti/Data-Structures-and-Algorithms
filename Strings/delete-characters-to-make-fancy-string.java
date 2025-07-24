//Problem: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/




import java.io.*;
import java.util.*;

class FancyString {
    public String deleteChars(String s) {
        char last = s.charAt(0);
        String ans = "";
        ans+=last;
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch==last) {
                count++;
                if(count < 3) {
                    ans+=ch;
                }
            } else {
                ans+=ch;
                last = ch;
                count = 1;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        FancyString str = new FancyString();
        System.out.println(str.deleteChars("leeetcode"));
        System.out.println(str.deleteChars("aaabaaaa"));
        System.out.println(str.deleteChars("aab"));
        System.out.println(str.deleteChars("pppppppp"));
    }
}