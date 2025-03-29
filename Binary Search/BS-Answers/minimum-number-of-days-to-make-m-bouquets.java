//Problem: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/


import java.io.*;
import java.util.*;

class MakeMBouquets {
    public int minimumDays(int[] bloomDays, int m, int k) {
        int maxDays=0;
        long totalFlowers = (long)m * k;
        if(totalFlowers > bloomDays.length) {
            return -1;
        }
        for(int i=0; i<bloomDays.length; i++) {
            maxDays = Math.max(maxDays, bloomDays[i]);
        }
        int l=1, r=maxDays;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(canMakeBouquets(bloomDays, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean canMakeBouquets(int[] bloomDays, int mid, int m, int k) {
        int flowers=0, bouquets=0;
        for(int i=0; i<bloomDays.length; i++) {
            if(bloomDays[i] <= mid) {
                flowers++;
            } else {
                if(flowers >= k) {
                    bouquets+=flowers/k;
                }
                flowers=0;
            }
        }
        if(flowers >= k) {
            bouquets+=flowers/k;
        }
        return bouquets >= m;
    }
    
}

class Main {
    public static void main(String[] args) {
        MakeMBouquets bouquets = new MakeMBouquets();
        int[] bloomDays = {1,10,3,10,2};
        System.out.println(bouquets.minimumDays(bloomDays, 3, 1));
        System.out.println(bouquets.minimumDays(bloomDays, 3, 2));
        
        int[] bloomDays1 = {7,7,7,7,12,7,7};
        System.out.println(bouquets.minimumDays(bloomDays1, 2, 3));
        
        int[] bloomDays2 = {1,10,2,9,3,8,4,7,5,6};
        System.out.println(bouquets.minimumDays(bloomDays2, 4, 2));
    }
}