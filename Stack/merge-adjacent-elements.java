//Problem: https://leetcode.com/problems/merge-adjacent-equal-elements/description/





import java.io.*;
import java.util.*;

class EqualElements {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> ans = new ArrayList<>();
        List<Long> arr = new ArrayList<>();
        Stack<Long> st = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            long curr = nums[i];
            if(!st.isEmpty() && st.peek()==curr) {
                while(!st.isEmpty() && st.peek()==curr) {
                    long sum = st.pop() + curr;
                    curr = sum;
                }
                st.add(curr);
            } else {
                st.add((long) nums[i]);
            }
        }

        while(!st.isEmpty()) {
            arr.add((long) st.pop());
        }

        for(int i=arr.size()-1; i>=0; i--) {
            ans.add(arr.get(i));
        }
        return ans;
    }
    
    public void display(List<Long> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        EqualElements elements = new EqualElements();
        int[] nums = {3,1,1,2};
        List<Long> ans = elements.mergeAdjacent(nums);
        elements.display(ans);
        
        int[] nums1 = {2,2,4};
        List<Long> ans1 = elements.mergeAdjacent(nums1);
        elements.display(ans1);
        
        int[] nums2 = {3,7,5};
        List<Long> ans2 = elements.mergeAdjacent(nums2);
        elements.display(ans2);
        
        int[] nums3 = {2,1,1,2};
        List<Long> ans3 = elements.mergeAdjacent(nums3);
        elements.display(ans3);
    }
}