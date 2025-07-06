//Problem: https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/




import java.io.*;
import java.util.*;

class FindSumPairs {
    int[] n1;
    int[] n2;
    HashMap<Integer, Integer> freq = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        for(int num: n2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        freq.put(n2[index], freq.getOrDefault(n2[index], 0) - 1);
        n2[index]+=val;
        freq.put(n2[index], freq.getOrDefault(n2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int pairs = 0;
        for(int num: n1) {
            int val = tot - num;
            pairs+=freq.getOrDefault(val, 0);
        }
        return pairs;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2,2,2,3};
        int[] nums2 = {1,4,5,2,5,4};
        FindSumPairs pairs = new FindSumPairs(nums1, nums2);
        System.out.println(pairs.count(7));
        pairs.add(3,2);
        System.out.println(pairs.count(8));
        System.out.println(pairs.count(4));
        pairs.add(0,1);
        pairs.add(1,1);
        System.out.println(pairs.count(7));
    }
}