//Problem: https://leetcode.com/problems/count-days-without-meetings/description/



import java.io.*;
import java.util.*;

class CountDaysWithoutMeetings {
    public int countFreeDays(int[][] meetings, int days) {
        int end=0, start=0, freeDays=0;
        Arrays.sort(meetings, (x,y)-> Integer.compare(x[0], y[0]));
        for(int i=0; i<meetings.length; i++) {
            if(meetings[i][0] > end) {
                freeDays+=meetings[i][0] - end - 1;
            }
            end=Math.max(meetings[i][1], end);
        }
        
        if(days > end) {
            freeDays+=days-end;
        }
        
        return freeDays;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] meetings = {{5,7}, {1,3}, {9,10}};
        CountDaysWithoutMeetings days = new CountDaysWithoutMeetings();
        System.out.println(days.countFreeDays(meetings, 10));
        
        int[][] meetings2 = {{4,8}, {3,4}, {2,5}, {2,8}};
        System.out.println(days.countFreeDays(meetings2, 8));
        
        int[][] meetings3 = {{1,6}};
        System.out.println(days.countFreeDays(meetings3, 6));
        
        int[][] meetings4 = {{2,3}, {1,4}};
        System.out.println(days.countFreeDays(meetings4, 5));
    }
}