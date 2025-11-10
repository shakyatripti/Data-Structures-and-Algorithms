//Problem: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/description/

//Problem: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/description/




import java.io.*;
import java.util.*;

class EqualThreeElements {
    public int minDistance(int[] nums) {
        int dist = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                ArrayList<Integer> indices = mp.get(nums[i]);
                indices.add(i);
                mp.put(nums[i], indices);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                mp.put(nums[i], indices);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()) {
            ArrayList<Integer> arr = entry.getValue();
            if(arr.size()>=3) {
                for(int i=0; i<arr.size()-2; i++) {
                    int first = arr.get(i);
                    int second = arr.get(i+1);
                    int third = arr.get(i+2);
                    int sum = Math.abs(first-second) + Math.abs(second-third) + Math.abs(third-first);
                    dist = Math.min(dist, sum);
                }
            }
        }
        return dist==Integer.MAX_VALUE ? -1 : dist;
    }
}

class Main {
    public static void main(String[] args) {
        EqualThreeElements arr = new EqualThreeElements();
        int[] nums = {1,2,1,1,3};
        System.out.println(arr.minDistance(nums));
        
        int[] nums1 = {1,1,2,3,2,1,2};
        System.out.println(arr.minDistance(nums1));
        
        int[] nums2 = {1};
        System.out.println(arr.minDistance(nums2));
    }
}