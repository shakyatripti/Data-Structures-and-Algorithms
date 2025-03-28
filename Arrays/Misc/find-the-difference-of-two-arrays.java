//Problem: https://leetcode.com/problems/find-the-difference-of-two-arrays/description/


import java.io.*;
import java.util.*;

class DifferenceInArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();
        for(int i: nums1) {
            st.add(i);
        }

        for(int i: nums2) {
            st2.add(i);
        }

        List<Integer> arr = new ArrayList<Integer>();
        for(int i: st) {
            if(!st2.contains(i)) {
                arr.add(i);
            }
        }

        List<Integer> arr2 = new ArrayList<Integer>();
        for(int i: st2) {
            if(!st.contains(i)) {
                arr2.add(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(arr);
        ans.add(arr2);
        return ans;
    }
    
    public void display(List<Integer> nums1) {
        for(int i: nums1) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        DifferenceInArrays arr = new DifferenceInArrays();
        List<List<Integer>> ans = arr.findDifference(nums1, nums2);
        arr.display(ans.get(0));
        arr.display(ans.get(1));
    }
}