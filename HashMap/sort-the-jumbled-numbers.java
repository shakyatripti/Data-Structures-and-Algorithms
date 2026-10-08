//Problem: https://leetcode.com/problems/sort-the-jumbled-numbers/description/





import java.io.*;
import java.util.*;


class JumbledNumbers {
    public int[] sorting(int[] mapping, int[] nums) {
        int n=nums.length, k=0, val=0;
        int[] ans = new int[n];
        int[] result = new int[n];
        TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        for(int i=0; i<n; i++) {
            val = mappedNum(nums[i], mapping);
            if(mp.containsKey(val)) {
                ArrayList<Integer> arr = mp.get(val);
                arr.add(nums[i]);
                mp.put(val, arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(nums[i]);
                mp.put(val, arr);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            for(int i=0; i<arr.size(); i++) {
                result[k] = arr.get(i);
                k++;
            }
        }
        return result;
    }

    public int mappedNum(int curr, int[] mapping) {
        int val = 0;
        StringBuilder str = new StringBuilder();
        while(curr!=0) {
            int r = curr%10;
            str.append(mapping[r]);
            curr=curr/10;
        }
        
        String s = str.reverse().toString();
        if(s.length()!=0) {
            val=Integer.valueOf(s);
        } else {
            val=mapping[0];
        }
        return val;
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
        JumbledNumbers arr = new JumbledNumbers();
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};
        int[] ans = arr.sorting(mapping, nums);
        arr.display(ans);

        int[] mapping1 = {0,1,2,3,4,5,6,7,8,9};
        int[] nums1 = {789,456,123};
        int[] ans1 = arr.sorting(mapping1, nums1);
        arr.display(ans1);

        int[] mapping2 = {0,1,2,3,4,5,6,7,8,9};
        int[] nums2 = {999999999,0};
        int[] ans2 = arr.sorting(mapping2, nums2);
        arr.display(ans2);
    }
}