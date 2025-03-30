//Problem: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/



import java.io.*;
import java.util.*;

class MaximumFullCapacityBags {
    public int countFullBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] availableCapacity = new int[capacity.length];
        int fullBags=0;
        for(int i=0; i<capacity.length; i++) {
            availableCapacity[i] = capacity[i] - rocks[i];
            if(availableCapacity[i]==0) {
                fullBags++;
            }
        }
        
        Arrays.sort(availableCapacity);
        for(int i=0; i<availableCapacity.length; i++) {
            if(availableCapacity[i]!=0 && availableCapacity[i]<=additionalRocks) {
                additionalRocks-=availableCapacity[i];
                fullBags++;
            }
        }
        return fullBags;
    }
}

class Main {
    public static void main(String[] args) {
        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};
        MaximumFullCapacityBags bags = new MaximumFullCapacityBags();
        System.out.println(bags.countFullBags(capacity, rocks, 2));
        
        int[] capacity2 = {10,2,2};
        int[] rocks2 = {2,2,0};
        System.out.println(bags.countFullBags(capacity2, rocks2, 100));
    }
}