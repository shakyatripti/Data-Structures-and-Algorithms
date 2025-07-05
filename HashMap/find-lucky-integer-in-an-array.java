//Problem: https://leetcode.com/problems/find-lucky-integer-in-an-array/description/




import java.io.*;
import java.util.*;

class LuckyInteger {
    public int findLucky(int[] arr) {
        int ans=-1;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry entry: freq.entrySet()) {
            int frequency = (int) entry.getValue();
            int val = (int) entry.getKey();
            if(val==frequency) {
                ans = Math.max(ans, val);
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LuckyInteger obj = new LuckyInteger();
        int[] arr = {2,2,3,4};
        System.out.println(obj.findLucky(arr));
        
        int[] arr1 = {1,2,2,3,3,3};
        System.out.println(obj.findLucky(arr1));
        
        int[] arr2 = {2,2,2,3,3};
        System.out.println(obj.findLucky(arr2));
    }
}