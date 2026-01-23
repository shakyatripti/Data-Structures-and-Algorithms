//Problem: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/




import java.io.*;
import java.util.*;

class SpecialDiscount {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] ans = new int[n];
        for(int i=0; i<prices.length; i++) {
            ans[i] = prices[i];
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]) {
                ans[st.peek()] = prices[st.peek()] - prices[i];
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SpecialDiscount item = new SpecialDiscount();
        int[] prices = {8,4,6,2,3};
        int[] ans = item.finalPrices(prices);
        item.display(ans);
        
        int[] prices1 = {1,2,3,4,5};
        int[] ans1 = item.finalPrices(prices1);
        item.display(ans1);
        
        int[] prices2 = {10,1,1,6};
        int[] ans2 = item.finalPrices(prices2);
        item.display(ans2);
    }
}