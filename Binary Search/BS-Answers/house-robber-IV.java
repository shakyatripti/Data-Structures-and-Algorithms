//Problem: https://leetcode.com/problems/house-robber-iv/description/



/*Problem Statement: We are given nums representing how much money is stashed in each house. There is also a robber, who wants to 
    steal money from the homes, but he refuses to steal from adjacent homes. The capability of the robber is the maximum amount of money 
    he steals from one house of all the houses he robbed. We need to find the minimum capability of the robber out of all the possible ways 
    to steal at least k houses.

    Let's say nums = {2,3,5,9}, k=2. The max money he can stole is 9 and min money is 2. We will use BS on Answers to solve this problem. 
    Here l=2, r=9 and in first iteration mid = 5, which means maximum amount of 5 he can steal in this case. Now robber starts robbery and steal 
    from house 0 with money as 2 and skips house 1 as robbery from adjacent house not possible. Then he steals from house 2 with money as 5 and goes out 
    of bound. So, robber has stolean atleast 2 houses and capability of robber in this case is max(2,5) = 5. Similarly we need to minimize the 
    capability of robber as much as possible. In second loop, l=2, r=4 and then same process goes on.
*/



import java.io.*;
import java.util.*;

class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int l=Integer.MAX_VALUE, r=Integer.MAX_VALUE, result=0;
        for(int i=0; i<nums.length; i++) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(isRobberyPossible(nums, mid, k)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    
    public boolean isRobberyPossible(int[] nums, int mid, int k) {
        int robbedHouses = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= mid) {
                robbedHouses++;
                i++;
            }
        }
        return robbedHouses >= k;
    }
}

class Main {
    public static void main(String[] args) {
        HouseRobberIV robber = new HouseRobberIV();
        int[] nums = {2,3,5,9};
        System.out.println(robber.minCapability(nums, 2));
        
        int[] nums1 = {2,7,9,3,1};
        System.out.println(robber.minCapability(nums1, 2));
    }
}