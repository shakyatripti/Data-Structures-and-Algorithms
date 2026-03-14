//Problem: https://leetcode.com/problems/find-the-duplicate-number/description/




import java.util.*;

class DuplicateNumber {

    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        DuplicateNumber obj = new DuplicateNumber();

        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {3,3,3,3,3};
       System.out.println(obj.findDuplicate(nums1));
        System.out.println(obj.findDuplicate(nums2));
        System.out.println(obj.findDuplicate(nums3));
    }
}