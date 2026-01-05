//Problem: https://leetcode.com/problems/average-waiting-time/description/





import java.io.*;
import java.util.*;

class WaitingTime {
    public double findAverage(int[][] customers) {
        long waitTime = 0, startTime = customers[0][0], finishTime = 0, count = customers.length;
        for(int i=0; i<count; i++) {
            finishTime = startTime + customers[i][1];
            waitTime+= finishTime - customers[i][0];
            if(i<count-1 && customers[i+1][0] > finishTime) {
                startTime = customers[i+1][0];
            } else {
                startTime = finishTime;
            }
        }
        return (double) waitTime/count;
    }
}


class Main {
    public static void main(String[] args) {
        WaitingTime time = new WaitingTime();
        int[][] customers = {{1,2},{2,5},{4,3}};
        System.out.println(time.findAverage(customers));
        
        int[][] customers1 = {{5,2},{5,4},{10,3},{20,1}};
        System.out.println(time.findAverage(customers1));
    }
}