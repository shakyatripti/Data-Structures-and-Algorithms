//Problem: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

import java.util.*;
import java.io.*;

class LexicographicallySmallestArray {
    public int[] smallestArray(int[] nums, int limit) {
        int n=nums.length, right=1, left=0;
        List<Pair> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr.add(new Pair(nums[i], i));
        }
        arr.sort(Comparator.comparingInt(p -> p.element));
        while(right < n) {
            ArrayList<Integer> groups = new ArrayList<>();
            groups.add(arr.get(left).index);
            while(right < n && (Math.abs(arr.get(right-1).element - arr.get(right).element) <=limit)) {
                groups.add(arr.get(right).index);
                right++;
            }
            Collections.sort(groups);
            for(int i=0; i<groups.size(); i++) {
                nums[groups.get(i)] = arr.get(left + i).element;
            }
            left = right;
            right++;
        }
        return nums;
    }
}

class Pair {
    int element;
    int index;
    Pair(int ele, int i) {
        element = ele;
        index = i;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,6,18,2,1};
        int limits = 3;
        LexicographicallySmallestArray array = new LexicographicallySmallestArray();
        int[] arr = array.smallestArray(nums, limits);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}