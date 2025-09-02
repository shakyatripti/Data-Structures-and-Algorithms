//Problem: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/





import java.io.*;
import java.util.*;

class MaximumCoins {
    public int getMax(int[] piles) {
        int coins = 0, l=0, r=piles.length-1, m=r-1;
        Arrays.sort(piles);
        while(l < m) {
            coins+=piles[m];
            l++;
            r-=2;
            m-=2;
        }
        return coins;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumCoins coins = new MaximumCoins();
        int[] piles = {2,4,1,2,7,8};
        System.out.println(coins.getMax(piles));
        
        int[] piles1 = {2,4,5};
        System.out.println(coins.getMax(piles1));
        
        int[] piles2 = {9,8,7,6,5,1,2,3,4};
        System.out.println(coins.getMax(piles2));
    }
}