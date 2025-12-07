//Problem: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description




import java.io.*;
import java.util.*;

class IntervalRange {
    public int countOdds(int low, int high) {
        int odds = (high - low)/2;
        if(high%2!=0 || low%2!=0) {
            odds++;
        }
        return odds;
    }
}

class Main {
    public static void main(String[] args) {
        IntervalRange arr = new IntervalRange();
        System.out.println(arr.countOdds(3,7));
        System.out.println(arr.countOdds(8,10));
        System.out.println(arr.countOdds(0, 1000000000));
    }
}