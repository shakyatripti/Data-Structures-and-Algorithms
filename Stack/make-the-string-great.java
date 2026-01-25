//Problem: https://leetcode.com/problems/make-the-string-great/description/





import java.io.*;
import java.util.*;

class GreatString {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder("");
        for(char ch: s.toCharArray()) {
            if(!st.isEmpty() && (st.peek()-'a'==ch-'A' || st.peek()-'A'==ch-'a')) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        str.reverse();
        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        GreatString str = new GreatString();
        System.out.println(str.makeGood("leEeetcode"));
        System.out.println(str.makeGood("abBAcC"));
        System.out.println(str.makeGood("s"));
        System.out.println(str.makeGood("Pp"));
    }
}