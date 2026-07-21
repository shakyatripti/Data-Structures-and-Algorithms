//Problem: https://leetcode.com/problems/baseball-game/description



import java.io.*;
import java.util.*;

class BaseballGame {
    public int calPoints(String[] operations) {
        int total = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<operations.length; i++) {
            String ch = operations[i];
            if(ch.equals("+")) {
                int first = st.pop();
                int second = st.pop();
                int sum = first + second;
                st.add(second);
                st.add(first);
                st.add(sum);
            } else if(ch.equals("C")) {
                st.pop();
            } else if(ch.equals("D")) {
                int last = st.peek();
                st.add(2*last);
            } else {
                int val = Integer.parseInt(ch);
                st.add(val);
            }
        }

        while(!st.isEmpty()) {
            total+=st.pop();
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(game.calPoints(ops));
        
        String[] ops1 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(game.calPoints(ops1));
        
        String[] ops2 = {"1", "C"};
        System.out.println(game.calPoints(ops2));
    }
}