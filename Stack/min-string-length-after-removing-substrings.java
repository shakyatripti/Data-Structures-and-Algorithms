//Problem: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/




import java.io.*;
import java.util.*;

class RemoveSubstrings {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(!st.isEmpty() && st.peek()=='A' && ch=='B') {
                st.pop();
            }
            else if(!st.isEmpty() && st.peek()=='C' && ch=='D') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.size();
    }
}


class Main {
    public static void main(String[] args) {
        RemoveSubstrings str = new RemoveSubstrings();
        System.out.println(str.minLength("ABFCACDB"));
        System.out.println(str.minLength("ACBBD"));
    }
}