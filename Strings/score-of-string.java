//Problem: https://leetcode.com/problems/score-of-a-string/description/




import java.io.*;
import java.util.*;

class ScoreOfString {
    public int findScore(String s) {
        int score = 0;
        for(int i=0; i<s.length()-1; i++) {
            int ch1 = (int) s.charAt(i);
            int ch2 = (int) s.charAt(i+1);
            score+=Math.abs(ch1-ch2);
        }
        return score;
    }
}

class Main {
    public static void main(String[] args) {
        ScoreOfString str = new ScoreOfString();
        System.out.println(str.findScore("hello"));
        System.out.println(str.findScore("zaz"));
    }
}