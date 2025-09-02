//Problem: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/descri





import java.io.*;
import java.util.*;

class ConvertArray {
	public List<List<Integer>> findMatrix(int[] nums) {
		int maxFreq=0;
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> mp = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
			maxFreq = Math.max(maxFreq, mp.get(nums[i]));
		}
		for(int i=0; i<maxFreq; i++) {
			arr.add(new ArrayList<>());
		}
		for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
			int val = entry.getKey();
			int freq = entry.getValue();
			for(int i=0; i<freq; i++) {
				arr.get(i).add(val);
			}
		}
		return arr;
	}

	public void display(List<List<Integer>> ans) {
		for(int i=0; i<ans.size(); i++) {
			for(int j=0; j<ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println("------");
	}
}

class Main {
	public static void main(String[] args) {
		ConvertArray arr = new ConvertArray();
		int[] nums = {1,3,4,1,2,3,1};
		List<List<Integer>> ans = arr.findMatrix(nums);
		arr.display(ans);

		int[] nums1 = {1,2,3,4};
        List<List<Integer>> ans1 = arr.findMatrix(nums1);
        arr.display(ans1);
	}
}