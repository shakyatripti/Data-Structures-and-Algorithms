//Problem: https://leetcode.com/problems/calculate-delayed-arrival-time/description/




import java.io.*;
import java.util.*;

class DelayedArrival {
    public int findDelayedTime(int arrivalTime, int delayedTime) {
        int totalTime = arrivalTime + delayedTime;
        return totalTime%24;
    }
}

class Main {
    public static void main(String[] args) {
        DelayedArrival station = new DelayedArrival();
        System.out.println(station.findDelayedTime(15, 5));
        System.out.println(station.findDelayedTime(13, 11));
    }
}