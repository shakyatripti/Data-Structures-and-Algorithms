//Problem: https://leetcode.com/problems/removing-stars-from-a-string/description 



import java.io.*;
import java.util.*;

class RemoveStars {
    public String remove(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch=='*') {
                st.pop();
            } else {
                st.add(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) { 
        RemoveStars str = new RemoveStars();
        System.out.println(str.remove("leet**cod*e"));
        System.out.println(str.remove("erase*****"));
        System.out.println(str.remove("phy**si*cs"));
        
    }
}