//Problem: https://leetcode.com/problems/lemonade-change/description/




import java.io.*;
import java.util.*;

class LemonadeChange {
    public boolean changePossible(int[] bills) {
        int five=0, ten=0, twenty=0;
        for(int i=0; i<bills.length; i++) {
            if(bills[i]==5) {
                five++;
            } else if(bills[i]==10 && five > 0) {
                int change = bills[i] - 5;
                ten++;
                five--;
            } else if(bills[i]==20 && five > 0 && ten > 0) {
                int change = bills[i] - 5;
                twenty++;
                five--;
                ten--;
            } else if(bills[i]==20 && five > 2) {
                int change = bills[i] - 5;
                twenty++;
                five = five - 3;
            } else {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        LemonadeChange lemonade = new LemonadeChange();
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonade.changePossible(bills));
        
        int[] bills2 = {5,5,10,10,20};
        System.out.println(lemonade.changePossible(bills2));
        
        int[] bills3 = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonade.changePossible(bills3));
        
    }
}