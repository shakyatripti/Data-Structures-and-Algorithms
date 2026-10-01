//Problem: https://leetcode.com/problems/valid-parentheses/description





import java.io.*;
import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch==')') {
                if(!st.isEmpty() && st.peek()=='(') {
                    st.pop();
                } else {
                    return false;
                }
            } else if(ch==']') {
                if(!st.isEmpty() && st.peek()=='[') {
                    st.pop();
                } else {
                    return false;
                }
            } else if(ch=='}') {
                if(!st.isEmpty() && st.peek()=='{') {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.add(ch);
            }
        }

        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
                 System.out.println(parentheses.isValid("()"));          System.out.println(parentheses.isValid("()[]{}"));    System.out.println(parentheses.isValid("(]"));       
System.out.println(parentheses.isValid("([])"));
System.out.println(parentheses.isValid("([)]")); System.out.println(parentheses.isValid("["));
System.out.println(parentheses.isValid("]"));        
    }
}