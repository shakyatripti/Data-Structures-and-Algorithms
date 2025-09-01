//Problem: https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/





import java.io.*;
import java.util.*;

class CollectGarbage {
    public int minTime(String[] garbage, int[] travel) {
        int lastG = -1, lastP = -1, lastM = -1, ans = 0;
        for(int i=0; i<garbage.length; i++) {
            String unit = garbage[i];
            for(char ch: unit.toCharArray()) {
                if(ch=='P') {
                    ans++;
                    lastP = i;
                }
                if(ch=='G') {
                    ans++;
                    lastG = i;
                }
                if(ch=='M') {
                    ans++;
                    lastM = i;
                }
            }
        }
        if(lastG!=-1) {
            int i=0;
            while(lastG!=0) {
               ans+=travel[i];
               i++;
               lastG--;
            }
        }
        if(lastP!=-1) {
            int i=0;
            while(lastP!=0) {
               ans+=travel[i];
               i++;
               lastP--;
            }
        }
        if(lastM!=-1) {
            int i=0;
            while(lastM!=0) {
               ans+=travel[i];
               i++;
               lastM--;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        CollectGarbage house = new CollectGarbage();
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(house.minTime(garbage, travel));
        
        String[] garbage1 = {"MMM","PGM","GP"};
        int[] travel1 = {3,10};
        System.out.println(house.minTime(garbage1, travel1));
    }
}