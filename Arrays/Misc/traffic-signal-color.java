//Problem: https://leetcode.com/problems/traffic-signal-color/description/




import java.io.*;
import java.util.*;

class TrafficSignal {
    public String findColor(int timer) {
        if(timer==0) {
            return "Green";
        } else if(timer==30) {
            return "Orange";
        } else if(timer > 30 && timer <= 90) {
            return "Red";
        }
        return "Invalid";
    }
}

class Main {
    public static void main(String[] args) {
        TrafficSignal traffic = new TrafficSignal();
        System.out.println(traffic.findColor(60));
        System.out.println(traffic.findColor(5));
        System.out.println(traffic.findColor(0));
         System.out.println(traffic.findColor(30));
    }
}