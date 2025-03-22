//Problem: https://leetcode.com/problems/koko-eating-bananas/description/



import java.io.*;
import java.util.*;

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for(int i=0; i<piles.length; i++) {
            maxBananas = Math.max(maxBananas, piles[i]);
        }
        int l=0, r=maxBananas;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(canFinish(piles, mid, h)) {
                r = mid;
            } else { 
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean canFinish(int[] piles, int mid, int h) {
        int hoursToEat = 0;
        for(int i=0; i<piles.length; i++) {
            hoursToEat+= piles[i]/mid;
            if(piles[i]%mid!=0) {
                hoursToEat++;
            }
        }
        return hoursToEat <= h;
    }
}

class Main {
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        KokoEatingBananas koko = new KokoEatingBananas();
        System.out.println(koko.minEatingSpeed(piles, 8));
        
        int[] piles2={30,11,23,4,20};
        System.out.println(koko.minEatingSpeed(piles2, 6));
    }
}