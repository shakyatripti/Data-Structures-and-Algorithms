//Problem: https://leetcode.com/problems/unique-number-of-occurrences/description/





import java.io.*;
import java.util.*;


class CountOccurrences {
    public boolean isUnique(int[] arr) {
        ArrayList<Integer> freq = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> it: mp.entrySet()) {
            int val = it.getValue();
            if(freq.contains(val)) {
                return false;
            }
            freq.add(val);
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        CountOccurrences num = new CountOccurrences();
        int[] arr = {1,2,2,1,1,3};
        System.out.println(num.isUnique(arr));
        
        int[] arr1 = {1,2};
        System.out.println(num.isUnique(arr1));
        
        int[] arr2 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(num.isUnique(arr2));
    }
}