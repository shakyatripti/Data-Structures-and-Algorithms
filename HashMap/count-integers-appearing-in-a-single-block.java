//Problem: https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/




import java.io.*;
import java.util.*;


class SingleBlock {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                ArrayList<Integer> arr = mp.get(nums[i]);
                arr.add(i);
                mp.put(nums[i], arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                mp.put(nums[i], arr);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            int flag=0;
            for(int i=0; i<arr.size()-1; i++) {
                if(arr.get(i+1)-arr.get(i) > 1) {
                    flag=1;
                }
            }
            if(flag==0) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        SingleBlock block = new SingleBlock();
        int[] nums = {1,2,2,1};
        System.out.println(block.countSpecialIntegers(nums));
        
        int[] nums1 = {3,3,1,2,2,1};
        System.out.println(block.countSpecialIntegers(nums1));
    }
}