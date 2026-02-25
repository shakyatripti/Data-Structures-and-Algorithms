//Problem: https://leetcode.com/problems/resulting-string-after-adjacent-removals/description/





import java.io.*;
import java.util.*;

class ResultingString {
    public String adjacentRemovals(String s) {
        Stack<Character> st = new Stack<>();
        int i=0;
        StringBuilder ans = new StringBuilder("");
        while(i < s.length()) {
            if(!st.isEmpty()) {
                int ch = st.peek() - 'a';
                int ch1 = s.charAt(i) - 'a';
                int diff = Math.abs(ch-ch1);
                if(diff==1 || diff==25) {
                    st.pop();
                    i++;
                } else {
                    st.add(s.charAt(i));
                    i++;
                }
            } else {
                st.add(s.charAt(i));
                i++;
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
        ResultingString str = new ResultingString();
        System.out.println(str.adjacentRemovals("abc"));
        System.out.println(str.adjacentRemovals("adcb"));
        System.out.println(str.adjacentRemovals("zadb"));
        System.out.println(str.adjacentRemovals("iwioccwvpdtjntmbpsaz"));
    }
}