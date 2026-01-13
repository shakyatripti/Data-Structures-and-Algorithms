//Problem: https://leetcode.com/problems/button-with-longest-push-time/description/




import java.io.*;
import java.util.*;

class ButtonPushTime {
    public int longestTime(int[][] events) {
        int prev = 0, ans = 0, res = 0;
        for(int i=0; i<events.length; i++) {
            int index = events[i][0], time = events[i][1];
            int diff = time - prev;
            if(diff==res) {
                ans = Math.min(ans, index);
            }
            if(diff > res) {
                res = diff;
                ans = index;
            }
            prev = time;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ButtonPushTime button = new ButtonPushTime();
        int[][] events = {{1,2},{2,5},{3,9},{1,15}};
        System.out.println(button.longestTime(events));
        
        int[][] events1 = {{10,5},{1,7}};
        System.out.println(button.longestTime(events1));
        
        int[][] events2 = {{7,2},{18,5},{18,8},{1,10},{10,12},{9,14},{3,15}};
        System.out.println(button.longestTime(events2));
    }
}