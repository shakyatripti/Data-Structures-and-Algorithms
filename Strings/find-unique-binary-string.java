//Problem: https://leetcode.com/problems/find-unique-binary-string/description/


import java.util.*;
import java.io.*;

class UniqueBinaryString {
    public String findBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> st = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            st.add(nums[i]);
        }
        return backtrack(st,n,"");
    }
    
    public String backtrack(HashSet<String> st, int n, String curr) {
        if(curr.length() == n) {
            if(!st.contains(curr)) {
                return curr;
            }
            return "";
        }
        String zeroes = backtrack(st,n,curr + "0");
        if(zeroes.length() > 0) {
            return zeroes;
        }
        return backtrack(st,n,curr + "1");
    }
}

class Main {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        String[] nums2 = {"00","01"};
        UniqueBinaryString str = new UniqueBinaryString();
        System.out.println(str.findBinaryString(nums));
        System.out.println(str.findBinaryString(nums2));
    }
}


