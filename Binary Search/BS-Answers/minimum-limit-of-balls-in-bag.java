//Problem: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/


/*Problem Statement: There are i bags with nums[i] balls. We want to do divide balls into two bags in atmost given operations.
    We have to divide in such a way so that our penalty is minimum. Penalty is calculated as the maximum ball present across all the bags.
    So basically we want to minimize the number of max balls across the bags.

    NOTE: In worst case we will not divide and the bag with max balls will be the penalty. 
*/

import java.io.*;
import java.util.*;

class MinLimitBallsInBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int maxBalls = 0;
        for(int i=0; i<nums.length; i++) {
            maxBalls = Math.max(nums[i], maxBalls);
        }
        
        int l=1, r=maxBalls;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(isDistributed(nums, mid, maxOperations)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean isDistributed(int[] nums, int mid, int maxOperations) {
        int totalOperations=0;
        for(int i=0; i<nums.length; i++) {
            totalOperations+=nums[i]/mid;
            if(nums[i]%mid==0) {
                totalOperations--;
            }
            
            if(totalOperations > maxOperations) {
                return false;
            }
        }
        return totalOperations <= maxOperations;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {2,4,8,2};
        MinLimitBallsInBag balls = new MinLimitBallsInBag();
        System.out.println(balls.minimumSize(nums, 4));
        
        int[] nums2 = {9};
        System.out.println(balls.minimumSize(nums2, 2));
    }
}