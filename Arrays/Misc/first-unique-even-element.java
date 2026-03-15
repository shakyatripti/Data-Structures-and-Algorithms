//Problem: https://leetcode.com/problems/first-unique-even-element/




import java.util.*;
import java.io.*;

class UniqueEvenNumber {

    public int firstUniqueEven(int[] nums) {
        int[] freq = new int[101];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && freq[nums[i]] == 1) {
                return nums[i];
            }
        }

        return -1;
    }
}


class Main {
    public static void main(String[] args) {
        UniqueEvenNumber obj = new UniqueEvenNumber();
        int[] nums1 = {3,4,2,5,4,6};
        System.out.println(obj.firstUniqueEven(nums1));
        
   