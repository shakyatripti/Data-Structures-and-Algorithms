//Problem: https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/description/



import java.io.*;
import java.util.*;


class ElapsedTime {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int time1 = calculateTotalSeconds(startTime);
        int time2 = calculateTotalSeconds(endTime);
        return time2-time1;
    }

    public int calculateTotalSeconds(String s) {
        String[] time = s.split("\\:");
        int s1 = Integer.valueOf(time[0]);
        int s2 = Integer.valueOf(time[1]);
        int s3 = Integer.valueOf(time[2]);
        return s1*60*60 + s2*60 + s3;
    }
}

class Main {
    public static void main(String[] args) {
        ElapsedTime time = new ElapsedTime();
        System.out.println(time.secondsBetweenTimes("01:00:00", "01:00:25"));
        System.out.println(time.secondsBetweenTimes("12:34:56", "13:00:00"));
    }
}