//Problem: https://leetcode.com/problems/calculate-score-after-performing-instructions/description/



import java.io.*;
import java.util.*;

class CalculateScore {
    public long score(String[] instructions, int[] values) {
        long totalScore = 0;
        int i=0;
        while(i >=0 && i<instructions.length && instructions[i]!="visited") {
            if(instructions[i].equals("jump")) {
                instructions[i] = "visited";
                i = i + values[i];
            } else {
                instructions[i] = "visited";
                totalScore+=values[i];
                i++;
            }
        }
        return totalScore;
    }
}


class Main {
    public static void main(String[] args) {
        CalculateScore scr = new CalculateScore();
        String[] instructions = {"jump","add","add","jump","add","jump"};
        int[] values = {2,1,3,1,-2,-3};
        System.out.println(scr.score(instructions, values));
        
        String[] instructions2 = {"jump","add","add"};
        int[] values2 = {3,1,1};
        System.out.println(scr.score(instructions2, values2));
        
        String[] instructions3 = {"jump"};
        int[] values3 = {0};
        System.out.println(scr.score(instructions3, values3));
    }
}



