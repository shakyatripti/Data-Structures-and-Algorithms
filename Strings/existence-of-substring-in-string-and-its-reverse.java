//Problem: https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/




import java.io.*;
import java.util.*;

class ExistenceSubstring {
    public boolean isSubstringPresent(String s) {
        Set<String> substr = new HashSet<>();
        for(int i=0; i<s.length()-1; i++) {
            substr.add(s.substring(i, i+2));
        }
        for(int i=s.length()-1; i>0; i--) {
            String reversed = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i - 1));
            if(substr.contains(reversed)) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ExistenceSubstring str = new ExistenceSubstring();
        System.out.println(str.isSubstringPresent("leetcode"));
        System.out.println(str.isSubstringPresent("abcba"));
        System.out.println(str.isSubstringPresent("abcd"));
    }
}