//Problem: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/



import java.io.*;
import java.util.*;


class Parentheses {
    public int maxDepth(String s) {
        int count = 0, ans = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch==')') {
                ans = Math.max(ans, count);
                st.pop();
                count--;
            } else if(ch=='(') {
                st.add(ch);
                count++;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Parentheses str = new Parentheses();
        System.out.println(str.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(str.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(str.maxDepth("()(())((()()))"));
    }
}