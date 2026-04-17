//Problem: https://leetcode.com/problems/goal-parser-interpretation/description/




import java.io.*;
import java.util.*;

class GoalParser {
    public String interpret(String command) {
        String ans = "";
        for(int i=0; i<command.length(); i++) {
            char ch = command.charAt(i);
            if(ch=='G') {
                ans+='G';
            } else if(ch=='(' && command.charAt(i+1)==')') {
                ans+='o';
                i++;
            } else {
                ans+='a';
                ans+='l';
                i+=3;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        GoalParser goal = new GoalParser();
        System.out.println(goal.interpret("G()(al)"));
        System.out.println(goal.interpret("G()()()()(al)"));
        System.out.println(goal.interpret("(al)G(al)()()G"));
    }
}