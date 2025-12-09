//Problem: https://leetcode.com/problems/sort-integers-by-binary-reflection/description/





import java.io.*;
import java.util.*;

class BinaryReflection {
    public int[] sortBy(int[] nums) {
        int idx = 0;
        int[] ans = new int[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(b[1]==a[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        for(int i=0; i<nums.length; i++) {
            int n = convertBinary(nums[i]);
            pq.add(new int[]{nums[i], n});
        }
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            ans[idx] = pair[0];
            idx++;
        }
        return ans;
    }

    public int convertBinary(int n) {
        int num = 0, k = 0;
        String str = new String("");
        while(n!=0) {
            int r = n%2;
            str+=r;
            n = n/2;
        }

        for(int i=str.length()-1; i>=0; i--) {
            num+=(str.charAt(i)-'0')*Math.pow(2,k);
            k++;
        }
        return num;
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
        BinaryReflection binary = new BinaryReflection();
        int[] nums = {4,5,4};
        int[] ans = binary.sortBy(nums);
        binary.display(ans);
        
        int[] nums1 = {3,6,5,8};
        int[] ans1 = binary.sortBy(nums1);
        binary.display(ans1);
    }
}