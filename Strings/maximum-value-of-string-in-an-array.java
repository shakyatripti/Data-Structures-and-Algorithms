//Problem: https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/




import java.io.*;
import java.util.*;

class AlphanumericStrings {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for(int i=0; i<strs.length; i++) {
            int flag = 0;
            for(char ch: strs[i].toCharArray()) {
                int val = ch - 'a';
                if(val>=0 && val<=25) {
                    flag = 1;
                    break;
                }
            }
            if(flag==1) {
                ans = Math.max(ans, strs[i].length());
            } else {
                ans = Math.max(ans, Integer.valueOf(strs[i]));
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        AlphanumericStrings arr = new AlphanumericStrings();
        String[] strs = {"alic3","bob","3","4","00000"};
        System.out.println(arr.maximumValue(strs));
        
        String[] strs1 = {"1","01","001","0001"};
        System.out.println(arr.maximumValue(strs1));
    }
}