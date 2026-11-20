//Problem: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/description/




import java.io.*;
import java.util.*;

class ModifyString {
    public String replaceCharacters(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char ch = 'a', prev = 'a', next = 'a';

                if (i - 1 >= 0) {
                    prev = ans.charAt(i - 1);
                }

                if (i + 1 < n) {
                    next = ans.charAt(i + 1);
                }

                while (prev == ch || next == ch) {
                    ch++;
                }

                ans.setCharAt(i, ch);
                s = ans.toString();
            }
        }

        return s;
    }
}

class Main {
    public static void main(String[] args) {
        ModifyString str = new ModifyString();

        System.out.println(str.replaceCharacters("?zs"));
        System.out.println(str.replaceCharacters("ubv?w"));
        System.out.println(str.replaceCharacters("j?qg??b"));
    }
}