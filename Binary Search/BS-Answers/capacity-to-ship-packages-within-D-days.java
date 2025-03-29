//Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/


import java.io.*;
import java.util.*;

class CapacityToShipPackages {
    public int minimumCapacity(int[] weights, int days) {
        int maxWeight=0, totalWeights=0;
        for(int i=0; i<weights.length; i++) {
            maxWeight = Math.max(weights[i], maxWeight);
            totalWeights+=weights[i];
        }
        int l=maxWeight, r=totalWeights;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(canBeltCarry(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean canBeltCarry(int[] weights, int mid, int days) {
        int daysRequired = 0, orgMid = mid;
        for(int i=0; i<weights.length; i++) {
            if(mid - weights[i] < 0) {
                daysRequired++;
                mid = orgMid;
            }
            mid-=weights[i];
        }
        if(mid >= 0) {
            daysRequired++;
        }
        return daysRequired <= days;
    }
}

class Main {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        CapacityToShipPackages ships = new CapacityToShipPackages();
        System.out.println(ships.minimumCapacity(weights, 5));
        System.out.println(ships.minimumCapacity(weights, 1));
        
        int[] weights2 = {1,2,3,1,1};
        System.out.println(ships.minimumCapacity(weights2, 4));
    }
}