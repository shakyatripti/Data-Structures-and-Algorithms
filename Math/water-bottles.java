//Problem: https://leetcode.com/problems/water-bottles/description/




import java.io.*;
import java.util.*;

class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = 0, ans=0;
        while(numBottles > 0) {
            ans+=numBottles;
            emptyBottles+=numBottles;
            numBottles=emptyBottles/numExchange;
            emptyBottles = emptyBottles%numExchange;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        WaterBottles bottles = new WaterBottles();
        System.out.println(bottles.numWaterBottles(9, 3));
        System.out.println(bottles.numWaterBottles(15, 4));
    }
}