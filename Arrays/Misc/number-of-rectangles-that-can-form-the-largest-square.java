//Problem: https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/description/



import java.io.*;
import java.util.*;

class GoodRectangles {
    public int countGoodRectangles(int[][] rectangles) {
        int n = rectangles.length, maxSide = -1, count = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int side = Math.min(rectangles[i][0], rectangles[i][1]);
            ans[i] = side;
            maxSide = Math.max(maxSide, side);
        }

        for (int i = 0; i < n; i++) {
            if (maxSide == ans[i]) {
                count++;
            }
        }

        return count;
    }
}

class Main {
    public static void main(String[] args) {
        GoodRectangles arr = new GoodRectangles();

        int[][] nums1 = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(arr.countGoodRectangles(nums1));

        int[][] nums2 = {{2, 3}, {3, 7}, {4, 3}, {3, 7}};
        System.out.println(arr.countGoodRectangles(nums2));
    }
}