//Problem: https://leetcode.com/problems/minimum-absolute-difference/description/





import java.io.*;
import java.util.*;

class AbsoluteDifference {
    public List<List<Integer>> minAbsDiff(int[] arr) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int minVal = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++) {
            minVal = Math.min(minVal, (arr[i+1] - arr[i]));
        }

        for(int i=0; i<arr.length-1; i++) {
            if(arr[i+1]-arr[i]==minVal) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
            }
        }
        return ans;
    }
    
    public void display(List<List<Integer>> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i).get(0) + " " + ans.get(i).get(1) + ",");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        AbsoluteDifference array = new AbsoluteDifference();
        int[] arr = {4,2,1,3};
        List<List<Integer>> ans = array.minAbsDiff(arr);
        array.display(ans);
        
        int[] arr1 = {1,3,6,10,15};
        List<List<Integer>> ans1 = array.minAbsDiff(arr1);
        array.display(ans1);
        
        int[] arr2 = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> ans2 = array.minAbsDiff(arr2);
        array.display(ans2);
    }
}