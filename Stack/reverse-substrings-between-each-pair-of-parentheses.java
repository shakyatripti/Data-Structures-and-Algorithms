//Problem: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/




import java.io.*;
import java.util.*;


class SubstringsPairs {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        for(char ch: s.toCharArray()) {
            if(ch==')') {
                String str = "";
                while(!st.isEmpty() && st.peek()!='(') {
                    str+=st.pop();
                }
                st.pop();

                for(int i=0; i<str.length(); i++) {
                    st.add(str.charAt(i));
                }
            } else {
                st.add(ch);
            }
        }

        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}

class Main {
    public static void main(String[] args) {
        SubstringsPairs pairs = new SubstringsPairs();
        System.out.println(pairs.reverseParentheses("(abcd)"));
        System.out.println(pairs.reverseParentheses("(u(love)i)"));
        System.out.println(pairs.reverseParentheses("(ed(et(oc))el)"));
    }
}
