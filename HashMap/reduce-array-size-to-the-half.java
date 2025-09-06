//Problem: https://leetcode.com/problems/reduce-array-size-to-the-half/description/





import java.io.*;
import java.util.*;

class ReduceArraySize {
    public int minSetSize(int[] arr) {
        int n = arr.length, m = n, count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            nums.add(entry.getValue());
        }
        Collections.sort(nums);
        int k=nums.size()-1;
        while(m > n/2) {
            m-=nums.get(k);
            k--;
            count++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        ReduceArraySize array = new ReduceArraySize();
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(array.minSetSize(arr));
        
        int[] arr1 = {7,7,7,7,7,7};
        System.out.println(array.minSetSize(arr1));
    }
}