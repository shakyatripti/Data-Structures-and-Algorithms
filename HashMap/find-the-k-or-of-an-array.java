//Problem: https://leetcode.com/problems/find-the-k-or-of-an-array/description/




import java.io.*;
import java.util.*;


class KOrArray {
    public int findKOr(int[] nums, int k) {
        int ans = 0, p = 0;
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int n=nums[i], count=0;
            while(n!=0) {
                int r = n%2;
                count++;
                if(mp.containsKey(count)) {
                    ArrayList<Integer> arr = mp.get(count);
                    arr.add(r);
                    mp.put(count, arr);
                } else {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(r);
                    mp.put(count, arr);
                }
                n=n/2;
            }
        }
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            int ones = 0;
            for(int i=0; i<arr.size(); i++) {
                if(arr.get(i)==1) {
                    ones++;
                }
            }
            if(ones>=k) {
                str.append("1");
            } else {
                str.append("0");
            }
        }
        String rev = str.toString();
        for(char ch: rev.toCharArray()) {
            if(ch=='1') {
                ans+=Math.pow(2, p);
            }
            p++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        KOrArray arr = new KOrArray();
        int[] nums = {7,12,9,8,9,15};
        System.out.println(arr.findKOr(nums, 4));
        
        int[] nums1 = {2,12,1,11,4,5};
        System.out.println(arr.findKOr(nums1, 6));
        
        int[] nums2 = {10,8,5,9,11,6,8};
        System.out.println(arr.findKOr(nums2, 1));
    }
}