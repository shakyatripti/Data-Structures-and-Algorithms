//Problem: https://leetcode.com/problems/most-profit-assigning-work/description/




import java.io.*;
import java.util.*;


class AssignWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit = 0, ans=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<difficulty.length; i++) {
            int val = mp.getOrDefault(difficulty[i], 0);
            mp.put(difficulty[i], Math.max(val, profit[i]));
        }
    
        Arrays.sort(difficulty);
        int[] maxProfitTillNow = new int[difficulty.length];
        maxProfitTillNow[0] = mp.get(difficulty[0]);
        for(int i=1; i<profit.length; i++) {
            maxProfitTillNow[i] = Math.max(maxProfitTillNow[i-1], mp.get(difficulty[i]));
        }
        for(int i=0; i<worker.length; i++) {
            int job = isAvailable(difficulty, worker[i], maxProfitTillNow);
            totalProfit+=job;
        }
        return totalProfit;
    }

    public int isAvailable(int[] difficulty, int target, int[] maxProfitTillNow) {
        int l=0, r=difficulty.length-1, ans=0, res=0;
        if(target < difficulty[l]) {
            return 0;
        }
        while(l <= r) {
            int mid =  l + (r-l)/2;
            if(difficulty[mid] > target) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return maxProfitTillNow[ans];
    }
}

class Main {
    public static void main(String[] args) {
        AssignWork work = new AssignWork();
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(work.maxProfitAssignment(difficulty, profit, worker));
        
        int[] difficulty1 = {85,47,57};
        int[] profit1 = {24,66,99};
        int[] worker1 = {40,25,25};
        System.out.println(work.maxProfitAssignment(difficulty1, profit1, worker1));
        
        int[] difficulty2 = {5,50,92,21,24,70,17,63,30,53};
        int[] profit2 = {68,100,3,99,56,43,26,93,55,25};
        int[] worker2 = {96,3,55,30,11,58,68,36,26,1};
        System.out.println(work.maxProfitAssignment(difficulty2, profit2, worker2));
        
        int[] difficulty3 = {1,3,5,4,11,9};
        int[] profit3 = {10,10,10,100,20,40};
        int[] worker3 = {5,19,12};
        System.out.println(work.maxProfitAssignment(difficulty3, profit3, worker3));
        
        int[] difficulty4 = {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
        int[] profit4 = {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
        int[] worker4 = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};
        System.out.println(work.maxProfitAssignment(difficulty4, profit4, worker4));
        
    }
}