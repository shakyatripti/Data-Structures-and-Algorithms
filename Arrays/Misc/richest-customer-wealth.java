//Problem: https://leetcode.com/problems/richest-customer-wealth/description/





import java.io.*;
import java.util.*;

class RichestCustomer {
    public int maxWealth(int[][] accounts) {
        int ans = 0;
        int m=accounts.length, n=accounts[0].length;
        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum+=accounts[i][j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        RichestCustomer customer = new RichestCustomer();
        int[][] accounts = {{1,2,3},{3,2,1}};
        System.out.println(customer.maxWealth(accounts));
        
        int[][] accounts1 = {{1,5},{7,3},{3,5}};
        System.out.println(customer.maxWealth(accounts1));
        
        int[][] accounts2 = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(customer.maxWealth(accounts2));
    }
}
