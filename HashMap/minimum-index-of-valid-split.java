//Problem: https://leetcode.com/problems/minimum-index-of-a-valid-split/description/



import java.io.*;
import java.util.*;

class MinIndexOfValidSplit {
    public int findMinimumIndex(List<Integer> nums) {
        int dominant=0, domFreq=0, n=nums.size()/2, leftCount=0, rightCount=0;
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.size(); i++) {
            freq.put(nums.get(i), freq.getOrDefault(nums.get(i), 0) + 1);
        }
        
        for(Map.Entry entry: freq.entrySet()) {
            if((int) entry.getValue() > n) {
                dominant = (int) entry.getKey();
                domFreq = (int) entry.getValue();
            }
        }
        
        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i)==dominant) {
                leftCount++;
            }
            rightCount = domFreq - leftCount;
            int leftSubArraySize = i+1;
            int rightSubArraySize = nums.size() - leftSubArraySize;
            if((leftCount > leftSubArraySize/2) && (rightCount > rightSubArraySize/2)) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,2,2));
        MinIndexOfValidSplit validSplit = new MinIndexOfValidSplit();
        System.out.println(validSplit.findMinimumIndex(nums));
        
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(2,1,3,1,1,1,7,1,2,1));
        System.out.println(validSplit.findMinimumIndex(nums2));
        
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(3,3,3,3,7,2,2));
        System.out.println(validSplit.findMinimumIndex(nums3));
    }
}