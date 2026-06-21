//Problem: https://leetcode.com/problems/maximum-ice-cream-bars/description




import java.io.*;
import java.util.*;


class IceCream {
    public int maxBars(int[] costs, int coins) {
        int count = 0, total = 0;
        Arrays.sort(costs);
        for(int i=0; i<costs.length; i++) {
            total+=costs[i];
            if(total <= coins) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        IceCream cream = new IceCream();
        int[] costs = {1,3,2,4,1};
        System.out.println(cream.maxBars(costs, 7));
        
        int[] costs1 = {10,6,8,7,7,8};
        System.out.println(cream.maxBars(costs1, 5));
        
        int[] costs2 = {1,6,3,1,2,5};
        System.out.println(cream.maxBars(costs2, 20));
    }
}