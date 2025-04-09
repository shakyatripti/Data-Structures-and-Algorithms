//Problem: https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/


//Brute force: With sorting

import java.io.*;
import java.util.*;

class MinOpsToMakeArrayEqualsK {
    public int minimumOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] < k) {
            return -1;
        }
        int operations = 0;
        if(nums[0] > k) {
            operations++;
        }
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[i-1]) {
                operations++;
            }
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        MinOpsToMakeArrayEqualsK arr = new MinOpsToMakeArrayEqualsK();
        int[] nums1 = {5,2,5,4,5};
        System.out.println(arr.minimumOperations(nums1, 2));
        
        int[] nums2 = {2,1,2};
        System.out.println(arr.minimumOperations(nums2, 2));
        
        int[] nums3 = {9,7,5,3};
        System.out.println(arr.minimumOperations(nums3, 1));
    }
}




//Optimal solution
import java.io.*;
import java.util.*;

class MinOpsToMakeArrayEqualsK {
    public int minimumOperations(int[] nums, int k) {
        int operations = 0;
        int[] visited = new int[101];
        Arrays.fill(visited, -1);
        for(int i=0; i<nums.length; i++)  {
            if(nums[i] < k) {
                return -1;
            }
            if(visited[nums[i]]==-1 && nums[i] > k) {
                operations++;
                visited[nums[i]] = 0;
            }
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        MinOpsToMakeArrayEqualsK arr = new MinOpsToMakeArrayEqualsK();
        int[] nums1 = {5,2,5,4,5};
        System.out.println(arr.minimumOperations(nums1, 2));
        
        int[] nums2 = {2,1,2};
        System.out.println(arr.minimumOperations(nums2, 2));
        
        int[] nums3 = {9,7,5,3};
        System.out.println(arr.minimumOperations(nums3, 1));
    }
}