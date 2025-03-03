//Problem: https://leetcode.com/problems/partition-array-according-to-given-pivot/description/



//Brute Force Solution
import java.io.*;
import java.util.*;

class PartitionArray {
    public int[] arrayPartitioned(int[] nums, int pivot) {
        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> larger = new ArrayList<Integer>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, pivot);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > pivot) {
                larger.add(nums[i]);
            }
            if(nums[i] < pivot) {
                smaller.add(nums[i]);
            }
        }
        
        for(int i=0; i<smaller.size(); i++) {
            ans[i] = smaller.get(i);
        }
        
        for(int j=0; j<larger.size(); j++) {
            ans[nums.length-larger.size() + j] = larger.get(j);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        PartitionArray arr = new PartitionArray();
        int[] ans = arr.arrayPartitioned(nums, 10);
        for(int i: ans) {
            System.out.print(i + " ");
        }
    }
}




//Better Solution
import java.io.*;
import java.util.*;

class PartitionArray {
    public int[] arrayPartitioned(int[] nums, int pivot) {
        int l=0, r=nums.length-1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, pivot);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < pivot) {
                ans[l] = nums[i];
                l++;
            }
        }
        
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] > pivot) {
                ans[r] = nums[i];
                r--;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        PartitionArray arr = new PartitionArray();
        int[] ans = arr.arrayPartitioned(nums, 10);
        for(int i: ans) {
            System.out.print(i + " ");
        }
    }
}



//Optimal solution
import java.io.*;
import java.util.*;

class PartitionArray {
    public int[] arrayPartitioned(int[] nums, int pivot) {
        int l=0, r=nums.length-1, i=0, j=nums.length-1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, pivot);
        while(l < nums.length && r >=0) {
            if(nums[l] < pivot) {
                ans[i] = nums[l];
                i++;
            }
        
            if(nums[r] > pivot) {
                ans[j] = nums[r];
                j--;
            }
            l++;
            r--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        PartitionArray arr = new PartitionArray();
        int[] ans = arr.arrayPartitioned(nums, 10);
        for(int i: ans) {
            System.out.print(i + " ");
        }
    }
}