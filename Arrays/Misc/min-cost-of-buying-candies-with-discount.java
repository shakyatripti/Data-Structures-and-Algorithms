//Problem: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/




import java.io.*;
import java.util.*;

class BuyCandiesWithDiscount {
    public int minCost(int[] cost) {
        int n=cost.length, sum=0, count=0;
        Arrays.sort(cost);
        for(int i=n-1; i>=0; i--) {
            if(count!=2) {
                sum+=cost[i];
                count++;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        BuyCandiesWithDiscount candies = new BuyCandiesWithDiscount();
        int[] cost = {1,2,3};
        System.out.println(candies.minCost(cost));
        
        int[] cost1 = {10,5,9,4,1,9,10,2,10,8};
        System.out.println(candies.minCost(cost1));
        
        int[] cost2 = {6,5,7,9,2,2};
        System.out.println(candies.minCost(cost2));
        
        int[] cost3 = {5,5};
        System.out.println(candies.minCost(cost3));
    }
}