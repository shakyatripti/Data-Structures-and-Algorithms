//Problem: https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/




import java.io.*;
import java.util.*;


class PalindromicString {
    public String findFirst(String[] words) {
        for(int i=0; i<words.length; i++) {
            StringBuilder str = new StringBuilder(words[i]);
            String s = str.toString();
            String rev = str.reverse().toString();
            if(s.equals(rev)) {
                return s;
            }
        }
        return "";
    }
}

class Main {
    public static void main() {
        PalindromicString str = new PalindromicString();
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        System.out.println(str.findFirst(words));
        
        String[] words1 = {"notapalindrome", "racecar"};
        System.out.println(str.findFirst(words1));
        
        String[] words2 = {"def", "ghi"};
        System.out.println(str.findFirst(words2));
    }
}