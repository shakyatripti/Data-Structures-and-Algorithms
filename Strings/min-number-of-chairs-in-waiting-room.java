//Problem: https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/




import java.io.*;
import java.util.*;

class WaitingRoom {
    public int minChairs(String s) {
        int chairs=0, persons=0;
        for(char ch: s.toCharArray()) {
            if(ch=='E') {
                persons++;
            } else {
                persons--;
            }
            chairs = Math.max(chairs, persons);
        }
        return chairs;
    }
}

class Main {
    public static void main(String[] args) {
        WaitingRoom room = new WaitingRoom();
        System.out.println(room.minChairs("EEEEEEE"));
        System.out.println(room.minChairs("ELELEEL"));
        System.out.println(room.minChairs("ELEELEELLL"));
        System.out.println(room.minChairs("ELEL"));
    }
}