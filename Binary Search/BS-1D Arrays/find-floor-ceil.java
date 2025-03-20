//Problem: https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401?leftPanelTab=0&leftPanelTabValue=PROBLEM



import java.io.*;
import java.util.*;

class FloorAndCeil {
    public int[] findFloorAndCeil(int[] arr, int x) {
        int l=0, r=arr.length-1, ceil=-1, floor=-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid] > x) {
                r = mid - 1;
            } else {
                floor = arr[mid];
                l = mid + 1;
            }
        }
        l=0; r=arr.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid] < x) {
                l = mid + 1;
            } else {
                ceil = arr[mid];
                r = mid - 1;
            }
        }
        int[] ans = new int[2];
        ans[0] = floor;
        ans[1] = ceil;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 8, 8, 10};
        FloorAndCeil nums = new FloorAndCeil();
        int[] ans = nums.findFloorAndCeil(arr,5);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] ans2 = nums.findFloorAndCeil(arr,7);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}