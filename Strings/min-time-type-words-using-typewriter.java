//Problem: https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/description




import java.io.*;
import java.util.*;

class MinTime {
    public int minTimeToType(String word) {
        int time=0;
        char ch = 'a';
        for(char curr: word.toCharArray()) {
           int secs = Math.min(Math.abs(curr-ch), 26 - Math.abs(curr-ch));
           time+=secs + 1;
           ch=curr;
        }
        return time;
    }
}

class Main {
    public static void main(String[] args) {
        MinTime typewriter = new MinTime();
        System.out.println(typewriter.minTimeToType("abc"));
        System.out.println(typewriter.minTimeToType("zjpc"));
        System.out.println(typewriter.minTimeToType("bza"));
    }
}