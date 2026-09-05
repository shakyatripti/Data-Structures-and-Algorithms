//Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array-ii/description/




import java.io.*;
import java.util.*;


class NumbersInArrayII {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        HashSet<Integer> arr = new HashSet<>();
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> num1 = new ArrayList<>();
        int start=Integer.MAX_VALUE, end=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
        }
        for(int i=lower; i<=upper; i++) {
            if(arr.contains(i)) {
                if(start!=Integer.MAX_VALUE && end!=Integer.MIN_VALUE) {
                    num1.add(start);
                    num1.add(end);
                    ans.add(num1);
                }
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
                num1 = new ArrayList<>();
            } else {
                start = Math.min(i, start);
                end = Math.max(i, end);
            }
        }
        
        if(start!=Integer.MAX_VALUE &&end!=Integer.MIN_VALUE) {
            num1.add(start);
            num1.add(end);
            ans.add(num1);
        }
        return ans;
    }
    
    public void display(List<List<Integer>> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        NumbersInArrayII arr = new NumbersInArrayII();
        int[] nums = {3,9,7};
        System.out.println(arr.findDisappearedNumbers(nums, 1, 12));
        
        int[] nums1 = {1,1};
        System.out.println(arr.findDisappearedNumbers(nums1, 5, 7));
        
        int[] nums2 = {2,3,5};
        System.out.println(arr.findDisappearedNumbers(nums2, 2, 3));
    }
}