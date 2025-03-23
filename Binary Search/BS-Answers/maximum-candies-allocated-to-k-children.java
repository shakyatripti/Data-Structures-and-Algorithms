//Problem: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/


/*Problem statement: There are candies given in array which we need to distribute among K children so that every children has exactly same
    number of candies with them. We need to find max no. of candies that we can distribute among them. For example {5,8,6}  and k=3, each 
    child can have 1 candy but we need to return max candies that can be distributed.

    NOTE: In worst case, all children will have candies equal to max_candies. Ex- {10,10,10} in this case every child will have 10 candies.
*/

import java.io.*;
import java.util.*;

class MaxCandiesAllocated {
    public int maximumCandies(int[] candies, long k) {
        int maxCandies = 0;
        long totalCandies = 0L;
        for(int i=0; i<candies.length; i++) {
            maxCandies = Math.max(candies[i] , maxCandies);
            totalCandies+=candies[i];
        }
        
        if(totalCandies < k) {
            return 0;
        }
        
        int l=1, r=maxCandies, ans=0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(canDistribute(candies, mid, k)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    
    public boolean canDistribute(int[] candies, int mid, long k) {
        long allocatedCandies = 0L;
        for(int i=0; i<candies.length; i++) {
            allocatedCandies+=candies[i]/mid;
            if(allocatedCandies >= k) {
                return true;
            }
        }
        
        return allocatedCandies >= k;
    }
}

class Main {
    public static void main(String[] args) {
        int[] candies = {5,8,6};
        MaxCandiesAllocated c = new MaxCandiesAllocated();
        System.out.println(c.maximumCandies(candies, 3));
        
        int[] candies2 = {2,5,3};
        System.out.println(c.maximumCandies(candies2, 11));
    }
}