//Problem: https://leetcode.com/problems/sort-array-by-increasing-frequency/description/





import java.io.*;
import java.util.*;

class IncreasingFrequency {
	public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            arr.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(arr, (a,b) -> {
            if(a[1]==b[1]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int k=0;
        for(int i=0; i<arr.size(); i++) {
            for(int j=0; j<arr.get(i)[1]; j++) {
                nums[k] = arr.get(i)[0];
                k++;
            }
        }
        return nums;
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
		IncreasingFrequency array = new IncreasingFrequency();
		int[] nums = {1,1,2,2,2,3};
		int[] ans = array.frequencySort(nums);
		array.display(ans);
		
		int[] nums1 = {2,3,1,3,2};
		int[] ans1 = array.frequencySort(nums1);
		array.display(ans1);
		
		int[] nums2 = {-1,1,-6,4,5,-6,1,4,1};
		int[] ans2 = array.frequencySort(nums2);
		array.display(ans2);
	}
}