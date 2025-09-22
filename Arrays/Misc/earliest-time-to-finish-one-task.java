//Problem: https://leetcode.com/problems/earliest-time-to-finish-one-task/description/




import java.io.*;
import java.util.*;

class FinishOneTask {
    public int earliestTime(int[][] tasks) {
        int time = Integer.MAX_VALUE;
        for(int i=0; i<tasks.length; i++) {
            time = Math.min(time, (tasks[i][0] + tasks[i][1]));
        }
        return time;
    }
}

class Main {
    public static void main(String[] args) {
        FinishOneTask task = new FinishOneTask();
        int[][] tasks = {{1,6},{2,3}};
        System.out.println(task.earliestTime(tasks));
        
        int[][] tasks1 = {{100,100}, {100,100}, {100,100}};
        System.out.println(task.earliestTime(tasks1));
    }
}