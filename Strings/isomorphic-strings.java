//Problem: https://leetcode.com/problems/isomorphic-strings/description/




import java.io.*;
import java.util.*;


class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        String first = mappedWords(s,t);
        String second = mappedWords(t,s);
        if(first.equals(t) && second.equals(s)) {
            return true;
        }
        return false;
    }

    public String mappedWords(String s, String t) {
        HashMap<Character, Character> mp = new HashMap<>();
        String curr = "";
        for(int i=0; i<s.length(); i++) {
            mp.put(s.charAt(i), t.charAt(i));
        }

        for(int i=0; i<s.length(); i++) {
            curr+=mp.get(s.charAt(i));
        }
        return curr;
    }
}


class Main {
    public static void main(String[] args) {
        IsomorphicStrings str = new IsomorphicStrings();
        System.out.println(str.isIsomorphic("egg", "add"));
        System.out.println(str.isIsomorphic("f11", "b23"));
        System.out.println(str.isIsomorphic("paper", "title"));
        System.out.println(str.isIsomorphic("badc", "baba"));
    }
}