//Problem: https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/



//Brute-force solution
import java.io.*;
import java.util.*;

class SumOfSubsetXor {
    List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    List<Integer> sets = new ArrayList<Integer>();
    public int subsetXorSum(int[] nums) {
        int ans = 0;
        findSubsets(nums, 0, sets);
        for(int i=0; i<subsets.size(); i++) {
            int sum = 0;
            for(int j=0; j<subsets.get(i).size(); j++) {
                sum^=subsets.get(i).get(j);
            }
            ans+=sum;
        }
        return ans;
    }
    
    public void findSubsets(int[] nums, int i, List<Integer> sets) {
        if(i==nums.length) {
            subsets.add(new ArrayList<>(sets));
            return;
        }
        sets.add(nums[i]);
        findSubsets(nums, i+1, sets);
        sets.remove(sets.size()-1);
        findSubsets(nums, i+1, sets);
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,3};
        SumOfSubsetXor sums = new SumOfSubsetXor();
        System.out.println(sums.subsetXorSum(nums));
        
        SumOfSubsetXor sums1 = new SumOfSubsetXor();
        int[] nums1 = {5,1,6};
        System.out.println(sums1.subsetXorSum(nums1));
        
        SumOfSubsetXor sums2 = new SumOfSubsetXor();
        int[] nums2 = {3,4,5,6,7,8};
        System.out.println(sums2.subsetXorSum(nums2));
    }
}



//Optimal solution
import java.io.*;
import java.util.*;

class SumOfSubsetXor {
    public int subsetXorSum(int[] nums) {
        return findSubsets(nums, 0, 0);
    }
    
    public int findSubsets(int[] nums, int i, int xor) {
        if(i==nums.length) {
            return xor;
        }
        int take = findSubsets(nums, i+1, xor^nums[i]);
        int skip = findSubsets(nums, i+1, xor);
        return take + skip;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,3};
        SumOfSubsetXor sums = new SumOfSubsetXor();
        System.out.println(sums.subsetXorSum(nums));
        
        int[] nums1 = {5,1,6};
        System.out.println(sums.subsetXorSum(nums1));
        
        int[] nums2 = {3,4,5,6,7,8};
        System.out.println(sums.subsetXorSum(nums2));
    }
}