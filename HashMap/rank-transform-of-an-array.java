//Problem: https://leetcode.com/problems/rank-transform-of-an-array/description/




import java.io.*;
import java.util.*;


class RankTransform {
    public int[] findRank(int[] arr) {
        int n=arr.length, k=1;
        int[] ans = Arrays.copyOf(arr, n);
        Arrays.sort(ans);
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(mp.containsKey(ans[i])) {
                mp.put(ans[i], mp.get(ans[i]));
            } else {
                mp.put(ans[i], k);
                k++;
            }
        }

        for(int i=0; i<n; i++) {
            ans[i] = mp.get(arr[i]);
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        RankTransform array = new RankTransform();
        int[] arr = {40,10,20,30};
        int[] ans = array.findRank(arr);
        array.display(ans);
        
        int[] arr1 = {100,100,100};
        int[] ans1 = array.findRank(arr1);
        array.display(ans1);
        
        int[] arr2 = {37,12,28,9,100,56,80,5,12};
        int[] ans2 = array.findRank(arr2);
        array.display(ans2);
    }
}