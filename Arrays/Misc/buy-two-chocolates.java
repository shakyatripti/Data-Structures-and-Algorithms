//Problem: https://leetcode.com/problems/buy-two-chocolates/description/



import java.io.*;
import java.util.*;

class BuyTwoChocolates {
    public int buyTwo(int[] prices, int money) {
        Arrays.sort(prices);
        int firstChoco = prices[0], secondChoco = prices[1];
        int totalPrice = firstChoco + secondChoco;
        if(totalPrice <= money) {
            return money - totalPrice;
        }
        return money;
    }
}

class Main {
    public static void main(String[] args) {
        BuyTwoChocolates choco = new BuyTwoChocolates();
        int[] prices = {1,2,2};
        System.out.println(choco.buyTwo(prices, 3));
        
        int[] prices1 = {3,2,3};
        System.out.println(choco.buyTwo(prices1, 3));
        
        int[] prices2 = {5,1,3,2};
        System.out.println(choco.buyTwo(prices2, 7));
    }
}