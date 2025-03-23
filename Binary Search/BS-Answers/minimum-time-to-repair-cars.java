//Problem: https://leetcode.com/problems/minimum-time-to-repair-cars/description/


/*Problem Statement: There is total cars given that is to be repaired by mechanics whose ranks is given by ranks[i]. 
    The time taken by any mechanic is calculated as rank*n*n where n is no. of cars he repaired. Now we need to find the minimum time
    so that all the cars will get repaired.
    
    NOTE: In worst case the max time will be the time taken by mechanic with highest rank, as time = rank*n*n. So the maxTime will be
    the total cars given to mechanic with highest rank. (MaxTime = highest_rank * total_Cars * total_Cars)
*/



import java.io.*;
import java.util.*;

class MinTimeToRepairCars {
    public long minimumTime(int[] ranks, int cars) {
        long maxTime = 0L;
        for(int i=0; i<ranks.length; i++) {
            maxTime = Math.max(ranks[i], maxTime);
        }
        
        long l=1L, r=1L*maxTime*cars*cars;
        while(l < r) {
            long mid = l + (r-l)/2;
            if(isRepaired(ranks,mid,cars)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean isRepaired(int[] ranks, long mid, int cars) {
        long carsRepaired = 0L;
        for(int i=0; i<ranks.length; i++) {
            carsRepaired+=Math.sqrt(mid/ranks[i]);
            if(carsRepaired >= cars) {
                return true;
            }
        }
        return carsRepaired >= cars;
    }
}

class Main {
    public static void main(String[] args) {
        int[] ranks = {1,2,3,4};
        MinTimeToRepairCars cars = new MinTimeToRepairCars();
        System.out.println(cars.minimumTime(ranks, 10));
        
        int[] ranks2 = {5,1,8};
        System.out.println(cars.minimumTime(ranks2, 4));
    }
}