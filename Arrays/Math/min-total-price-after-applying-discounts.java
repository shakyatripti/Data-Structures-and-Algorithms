//Problem: https://leetcode.com/problems/minimum-total-price-after-applying-discounts/description/





import java.io.*;
import java.util.*;


class TotalPrice {
    public double applyDiscount (int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n=discounts.length-1, m=prices.length-1, len = Math.min(n, m);
        double result = 0;
        for(int i=len; i>=0; i--) {
            double ans = (double) (prices[m] * (100 - discounts[n])) / 100;
            m--;
            n--;
            result+=ans;
        }
        
        while(m>=0) {
            result+=prices[m];
            m--;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        TotalPrice item = new TotalPrice();
        int[] prices = {10,30,21};
        int[] discounts = {50,60};
        System.out.println(item.applyDiscount(prices, discounts));
        
        int[] prices1 = {100,70};
        int[] discounts1 = {10,40,50};
        System.out.println(item.applyDiscount(prices1, discounts1));
        
        int[] prices2 = {7,3,9};
        int[] discounts2 = {100, 100};
        System.out.println(item.applyDiscount(prices2, discounts2));
    }
}