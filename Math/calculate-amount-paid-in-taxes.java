//Problem: https://leetcode.com/problems/calculate-amount-paid-in-taxes/description





import java.io.*;
import java.util.*;

class PaidTaxes {
    public double calculateTax(int[][] brackets, int income) {
        int prev = 0;
        double taxes = 0;
        for(int i=0; i<brackets.length; i++) {
            int curr = Math.min(brackets[i][0], income) - prev;
            if(curr > 0) {
                double percent = (double) (brackets[i][1])/100;
                taxes+=curr*percent;
                prev = brackets[i][0];
            }
        }
        return taxes;
    }
}


class Main {
    public static void main(String[] args) {
        PaidTaxes amt = new PaidTaxes();
        int[][] brackets = {{3,50},{7,10},{12,25}};
        System.out.println(amt.calculateTax(brackets, 10));
        
        int[][] brackets1 = {{1,0},{4,25},{5,50}};
        System.out.println(amt.calculateTax(brackets1, 2));
        
        int[][] brackets2 = {{2,50}};
        System.out.println(amt.calculateTax(brackets2, 0));
    }
}