//Problem: https://leetcode.com/problems/assign-umbrella-on-rainy-days/description/



import java.io.*;
import java.util.*;

class RainyDays {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length, count = 0, count1 = 0;
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && rain[i] == rain[i + 1] && rain[i] == 1) {
                if (count1 >= count) {
                    ans[i] = "Alice";
                    count++;
                } else {
                    ans[i] = "Bob";
                    count1++;
                }
            } else if (rain[i] == 1) {
                ans[i] = "Bob";
                count1++;
            } else {
                ans[i] = "None";
            }
        }
        return ans;
    }

    public void display(String[] ans) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        RainyDays arr = new RainyDays();

        int[] nums1 = {1, 1, 0, 1, 1};
        String[] ans1 = arr.assignUmbrella(nums1);
        arr.display(ans1);

        int[] nums2 = {0, 1, 0, 1};
        String[] ans2 = arr.assignUmbrella(nums2);
        arr.display(ans2);

        int[] nums3 = {1, 0, 1, 1, 1};
        String[] ans3 = arr.assignUmbrella(nums3);
        arr.display(ans3);

        int[] nums4 = {1, 1, 1};
        String[] ans4 = arr.assignUmbrella(nums4);
        arr.display(ans4);
    }
}