//Problem: https://leetcode.com/problems/koko-eating-bananas/description/

/* Problem statement: There are piles of bananas and hours given for which guard is not there in garden. We need to find min speed of Koko
    so that she can eat all the bananas before guard returns. For example {3,6,7,11} are bananas piles and guard is out for 8 hours.
    If she started eating 11 bananas per hour she will be able to finish all the piles in 4 hours. But we need to find min speed of her 
    eating bananas per hour. 

    NOTE: In worst case she will eat max bananas per hour to empty the piles before guard arrives.
*/

import java.io.*;
import java.util.*;

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for(int i=0; i<piles.length; i++) {
            maxBananas = Math.max(maxBananas, piles[i]);
        }
        int l=1, r=maxBananas;
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