//Problem: https://leetcode.com/problems/robot-return-to-origin/description/



import java.io.*;
import java.util.*;

class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x=0, y=0;
        for(char ch: moves.toCharArray()) {
            if(ch=='U') {
                y++;
            } else if(ch=='D') {
                y--;
            } else if(ch=='R') {
                x++;
            } else {
                x--;
            }
        }
        if(x==0 && y==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        RobotReturnToOrigin robot = new RobotReturnToOrigin();
        System.out.println(robot.judgeCircle("UD"));
        System.out.println(robot.judgeCircle("LL"));
        System.out.println(robot.judgeCircle("RRDD"));
    }
}