//Problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/




import java.io.*;
import java.util.*;

class ReversePolishNotation{
    public int evaluate(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        int i=0;
        while(i!=tokens.length) {
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                st.add(Integer.valueOf(tokens[i]));
            } else {
                int first = st.pop();
                int second = st.pop();
                if(tokens[i].equals("+")) {
                    st.add(first+second);
                } else if(tokens[i].equals("*")) {
                    st.add(second*first);
                } else if(tokens[i].equals("/")) {
                    st.add(second/first);
                } else {
                    st.add(second-first);
                }
            }
            i++;
        }
        return st.pop();
    }
}

class Main {
    public static void main(String[] args) {
        ReversePolishNotation notation = new ReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(notation.evaluate(tokens));
        
        String[] tokens1 = {"4","13","5","/","+"};
        System.out.println(notation.evaluate(tokens1));
        
        String[] tokens2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(notation.evaluate(tokens2));
    }
}