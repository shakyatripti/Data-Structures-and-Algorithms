//Problem: https://leetcode.com/problems/count-dominant-elements/description/





import java.io.*;
import java.util.*;

class DominantElements {
    public int count(int[] nums) {
        int n = nums.length, count = 0, i = 0;

        if (n == 1) {
            return 1;
        }

        if (i == 0 && nums[i] >= nums[i + 1]) {
            count++;
        }

        for (i = 1; i < n - 1; i++) {
            double avg = (double) (nums[i - 1] + nums[i + 1]) / 2;

            if (nums[i] >= avg) {
                count++;
            }
        }

        if (i == n - 1 && nums[i] >= nums[i - 1]) {
            count++;
        }

        return count;
    }
}

class Main {
    public static void main(String[] args) {
        DominantElements arr = new DominantElements();

        int[] nums1 = {1, 10, 2};
        System.out.println(arr.count(nums1));

        int[] nums2 = {6, 4, 2};
        System.out.println(arr.count(nums2));

        int[] nums3 = {7};
        System.out.println(arr.count(nums3));

        int[] nums4 = {1, 1};
        System.out.println(arr.count(nums4));

        int[] nums5 = {96, 75, 55};
        System.out.println(arr.count(nums5));
    }
}