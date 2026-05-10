//Problem: https://leetcode.com/problems/score-validator/description/




import java.io.*;
import java.util.*;


class ScoreValidator {
    public int[] finalScoreAndCounter(String[] events) {
        int[] ans = new int[2];
        int score=0, counter=0, i=0;
        while(i < events.length && counter!=10){
            String s = events[i];
            if(s.equals("WD") || s.equals("NB")) {
                score++;
            } else if(s.equals("W")) {
                counter++;
            } else {
                score+=Integer.valueOf(s);
            }
            i++;
        }
        ans[0] = score;
        ans[1] = counter;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ScoreValidator num = new ScoreValidator();
        String[] events = {"1","4","W","6","WD"};
        int[] ans = num.finalScoreAndCounter(events);
        System.out.println(ans[0] + " " + ans[1]);
        
        String[] events1 = {"WD","NB","0","4","4"};
        int[] ans1 = num.finalScoreAndCounter(events1);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        String[] events2 = {"W","W","W","W","W","W","W","W","W","W","W"};
        int[] ans2 = num.finalScoreAndCounter(events2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}