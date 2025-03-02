//Problem: https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/


//Brute force solution
import java.io.*;
import java.util.*;

class Merge2DArraysBySum {
    public int[][] mergeArray(int[][] arr1, int[][] arr2) {
        int size = 0, index =0;
        Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        for(int i=0; i<arr1.length; i++) {
            mp.put(arr1[i][0], arr1[i][1]);
            size++;
        }
        for(int i=0; i<arr2.length; i++) {
            if(mp.containsKey(arr2[i][0])) {
                mp.put(arr2[i][0], mp.get(arr2[i][0]) + arr2[i][1]);
            } else {
                mp.put(arr2[i][0], arr2[i][1]);
                size++;
            }
        }
        int[][] ans = new int[size][2];
        for(Map.Entry entry: mp.entrySet()) {
            int id = (int) entry.getKey();
            int val = (int) entry.getValue();
            ans[index][0] = id;
            ans[index][1] = val;
            index++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3},{4,5}};
        int[][] arr2 = {{1,4},{3,2},{4,1}};
        Merge2DArraysBySum arr = new Merge2DArraysBySum();
        int[][] ans = arr.mergeArray(arr1, arr2);
        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i][0] +  " " + ans[i][1]);
        }
    }
}



//Optimal solution
import java.io.*;
import java.util.*;

class Merge2DArraysBySum {
    public int[][] mergeArray(int[][] arr1, int[][] arr2) {
        ArrayList<int[]> sums = new ArrayList<>();
        int l=0, r=0, index = 0;
        while(l < arr1.length && r < arr2.length) {
            if(arr1[l][0]==arr2[r][0]) {
                int sum = arr1[l][1] + arr2[r][1];
                sums.add(new int[]{arr1[l][0], sum});
                l++;
                r++;
            } else if(arr1[l][0] < arr2[r][0]) {
                sums.add(new int[]{arr1[l][0], arr1[l][1]});
                l++;
            } else {
                sums.add(new int[]{arr2[r][0], arr2[r][1]});
                r++;
            }
        }
        
        while(l < arr1.length) {
            sums.add(new int[]{arr1[l][0], arr1[l][1]});
            l++;
        }
        
        while(r < arr2.length) {
            sums.add(new int[]{arr2[r][0], arr2[r][1]});
            r++;
        }
        
        int[][] ans = new int[sums.size()][2];
        for(int i=0; i<sums.size(); i++) {
            ans[i] = sums.get(i);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,4},{4,5}};
        int[][] arr2 = {{1,4},{3,2},{4,2}};
        Merge2DArraysBySum arr = new Merge2DArraysBySum();
        int[][] ans = arr.mergeArray(arr1, arr2);
        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i][0] +  " " + ans[i][1]);
        }
    }
}