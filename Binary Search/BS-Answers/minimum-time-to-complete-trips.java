//Problem: https://leetcode.com/problems/minimum-time-to-complete-trips/description/



import java.io.*;
import java.util.*;

class MinTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long fastest= Long.MAX_VALUE;
        for(int i=0; i<time.length; i++) {
            fastest = Math.min(fastest, (long) time[i]);
        }
        
        long l=1, r=fastest*totalTrips;
        while(l<r) {
            long mid = l + (r-l)/2;
            if(isTripCompleted(time, mid, totalTrips)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean isTripCompleted(int[] time, long mid, int totalTrips) {
        long tripsCompleted = 0L;
        for(int i=0; i<time.length; i++) {
            tripsCompleted+=mid/(long) time[i];
            if(tripsCompleted >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        int[] time = {1,2,3};
        MinTimeToCompleteTrips trips = new MinTimeToCompleteTrips();
        System.out.println(trips.minimumTime(time, 5));
        
        int[] time1 = {2};
        System.out.println(trips.minimumTime(time1, 1));
    }
}