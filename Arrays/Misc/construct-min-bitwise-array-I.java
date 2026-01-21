//Problem: https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/description/





import java.io.*;
import java.util.*;

class ConstructArrayI {
    public int[] minBitwiseI(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            ans[i] = -1;
            for(int j=0; j<=nums.get(i); j++) {
                int val = j | (j+1);
                if(val==nums.get(i)) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
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
        ConstructArrayI arr = new ConstructArrayI();
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,3,5,7));
        int[] ans = arr.minBitwiseI(nums);
        arr.display(ans);
        
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(11,13,31));
        int[] ans1 = arr.minBitwiseI(nums1);
        arr.display(ans1);
    }
}