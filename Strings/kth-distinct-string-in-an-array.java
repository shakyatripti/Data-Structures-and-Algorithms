//Problem: https://leetcode.com/problems/kth-distinct-string-in-an-array/description/




import java.io.*;
import java.util.*;

class DistinctString {
    public String kthDistinct(String[] arr, int k) {
        ArrayList<String> st = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) +1);
        }

        for(int i=0; i<arr.length; i++) {
            if(mp.get(arr[i])==1) {
                st.add(arr[i]);
            }
        }

        if(st.size() < k) {
            return "";
        }
        return st.get(k-1);
    }
}

class Main {
    public static void main(String[] args) {
        DistinctString str = new DistinctString();
        String[] arr = {"d","b","c","b","c","a"};
        System.out.println(str.kthDistinct(arr, 2));
        
        String[] arr1 = {"aaa","aa","a"};
        System.out.println(str.kthDistinct(arr1, 1));
        
        String[] arr2 = {"a","b","a"};
        System.out.println(str.kthDistinct(arr2, 3));
    }
}