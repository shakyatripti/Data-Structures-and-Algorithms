//Problem: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/




import java.io.*;
import java.util.*;


class ValidParentheses {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()) {
            if(ch==')' && !st.isEmpty() && st.peek()=='(') {
                st.pop();
            } else {
                st.add(ch);
            }
        }

        return st.size();
    }
}

class Main {
    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.minAddToMakeValid("())"));
        System.out.println(parentheses.minAddToMakeValid("((("));
        System.out.println(parentheses.minAddToMakeValid("()))(("));
    }
}