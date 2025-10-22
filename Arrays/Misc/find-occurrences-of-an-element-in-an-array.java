//Problem: https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/





import java.io.*;
import java.util.*;

class FindOccurrences {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int index = 1;
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==x) {
                indices.add(i);
                index++;
            }
        }
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for(int i=0; i<queries.length; i++) {
            if(indices.size() >= queries[i]) {
                ans[i] = indices.get(queries[i]-1);
            }
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
        FindOccurrences arr = new FindOccurrences();
        int[] nums = {1,3,1,7};
        int[] queries = {1,3,2,4};
        int[] ans = arr.occurrencesOfElement(nums, queries, 1);
        arr.display(ans);
        
        int[] nums1 = {1,2,3};
        int[] queries1 = {10};
        int[] ans1 = arr.occurrencesOfElement(nums1, queries1, 5);
        arr.display(ans1);
    }
}