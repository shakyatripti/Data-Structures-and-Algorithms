//Problem: https://leetcode.com/problems/minimum-time-to-complete-trips/description/


/*Problem statement: There is time arary which show time taken by vehicles. We need to find min time so that total trips completed
    by vehicles should be more/equal than totalTrips. For example {1,2,3} are time taken A,B and C vehicles and totalTrips that needs to
    be completed is 5. Let's suppose all vehicles started at 1 sec, so only A will complete 1 trip. In 2sec, A will complete 2 trips and B will
    complete 1 trip. In 3sec, A will complete 3 trips, B will complete 1 trip(because to complete 2 trips it will require 4 secs), C will complete 1 trip.
    So in total 5 trips are completed. In similar way check if time less than 3sec will work or not.

    NOTE: Min time taking vehicle will be fastest and will take min time to complete trips. So our right value for BS will be min_time * total_trips.
        Because in 5secs vehicle A will have already completed 5 trips.
*/



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