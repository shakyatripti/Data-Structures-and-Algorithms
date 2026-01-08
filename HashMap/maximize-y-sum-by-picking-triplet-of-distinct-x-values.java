//Problem: https://leetcode.com/problems/maximize-ysum-by-picking-a-triplet-of-distinct-xvalues/description/




import java.io.*;
import java.util.*;

class DistinctTriplet {
    public int maxSum(int[] x, int[] y) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<x.length; i++) {
            if(mp.containsKey(x[i])) {
                int val = Math.max(mp.get(x[i]), y[i]);
                mp.put(x[i], val);
            } else {
                mp.put(x[i], y[i]);
            }
        }
        if(mp.size() < 3) {
            return -1;
        }

        for(Map.Entry<Integer, Integer> it: mp.entrySet()) {
            arr.add(it.getValue());
        }
        Collections.sort(arr);
        int n=arr.size()-1;
        return arr.get(n) + arr.get(n-1) + arr.get(n-2);
    }
}

class Main {
    public static void main(String[] args) {
        DistinctTriplet triplet = new DistinctTriplet();
        int[] x = {1,2,1,3,2};
        int[] y = {5,3,4,6,2};
        System.out.println(triplet.maxSum(x, y));
        
        int[] x1 = {1,2,1,2};
        int[] y1 = {4,5,6,7};
        System.out.println(triplet.maxSum(x1, y1));
    }
}