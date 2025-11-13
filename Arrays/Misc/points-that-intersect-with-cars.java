//Problem: https://leetcode.com/problems/points-that-intersect-with-cars/description/





import java.io.*;
import java.util.*;

class PointsThatIntersect {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.size(); i++) {
            int start = nums.get(i).get(0), end = nums.get(i).get(1);
            for(int j=start; j<=end; j++) {
                st.add(j);
            }
        }
        return st.size();
    }
}

class Main {
    public static void main(String[] args) {
        PointsThatIntersect obj = new PointsThatIntersect();
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        nums.add(Arrays.asList(3,6));
        nums.add(Arrays.asList(1,5));
        nums.add(Arrays.asList(4,7));
        System.out.println(obj.numberOfPoints(nums));
   
        List<List<Integer>> nums1 = new ArrayList<List<Integer>>();
        nums1.add(Arrays.asList(1,3));
        nums1.add(Arrays.asList(5,8));
        System.out.println(obj.numberOfPoints(nums1));
        
        List<List<Integer>> nums2 = new ArrayList<List<Integer>>();
        nums2.add(Arrays.asList(2,5));
        nums2.add(Arrays.asList(4,6));
        System.out.println(obj.numberOfPoints(nums2));
    }
}