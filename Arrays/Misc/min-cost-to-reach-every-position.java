
//Problem: https://leetcode.com/problems/minimum-cost-to-reach-every-position/description/




import java.io.*;
import java.util.*;

class ReachEveryPosition {
    public int[] minCosts(int[] cost) {
        int[] ans = new int[cost.length];
        ans[0] = cost[0];
        for(int i=1; i<cost.length; i++) {
            if(cost[i] <= ans[i-1]) {
                ans[i] = cost[i];
            }
            if(cost[i] > ans[i-1]) {
                ans[i] = ans[i-1];
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ReachEveryPosition arr = new ReachEveryPosition();
        int[] costs = {5,3,4,1,3,2};
        int[] ans = arr.minCosts(costs);
        arr.display(ans);
        
        int[] costs1 = {1,2,4,6,7};
        int[] ans1 = arr.minCosts(costs1);
        arr.display(ans1);
        
        int[] costs2 = {1,15,9,7,16,20,2,15,4,5,18,6,1,16,9,19,15,5,6};
        int[] ans2 = arr.minCosts(costs2);
        arr.display(ans2);
        
    }
}