//Problem: https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/description/





import java.io.*;
import java.util.*;


class LongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int prev = logs[0][1], ans = 0;
        for(int i=0; i<logs.length; i++) {
            if(logs[i][0] > prev) {
                prev = logs[i][0];
            }
            int time = prev - logs[i][0];
            ans = Math.max(ans, time);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LongestTask task = new LongestTask();
        int[][] logs = {{0,3},{2,5},{0,9},{1,15}};
        System.out.println(task.hardestWorker(10, logs));
        
        int[][] logs1 = {{1,1},{3,7},{2,12},{7,17}};
        System.out.println(task.hardestWorker(26, logs1));
        
        int[][] logs2 = {{0,10},{1,20}};
        System.out.println(task.hardestWorker(2, logs2));
    }
}