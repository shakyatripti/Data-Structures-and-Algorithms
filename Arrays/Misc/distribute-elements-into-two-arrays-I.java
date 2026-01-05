//Problem: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/




import java.io.*;
import java.util.*;

class DistributeElements {
    public int[] resultArray(int[] nums) {
        int n=nums.length, k=0;
        int[] ans = new int[n];
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2; i<n; i++) {
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        for(int i=0; i<arr1.size(); i++) {
            ans[k] = arr1.get(i);
            k++;
        }

        for(int j=0; j<arr2.size(); j++) {
            ans[k] = arr2.get(j);
            k++;
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
        DistributeElements arr = new DistributeElements();
        int[] nums = {2,1,3};
        int[] ans = arr.resultArray(nums);
        arr.display(ans);
        
        int[] nums1 = {5,4,3,8};
        int[] ans1 = arr.resultArray(nums1);
        arr.display(ans1);
    }
}