//Problem: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/




import java.io.*;
import java.util.*;

class TargetArray {
    public int minIncrements(int[] target) {
        int operations = target[0], prev = target[0];
        for(int i=1; i<target.length; i++) {
            if(target[i] > prev) {
                operations+=target[i] - prev;
            }
            prev = target[i];
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        TargetArray arr = new TargetArray();
        int[] target = {1,2,3,2,1};
        System.out.println(arr.minIncrements(target));
        
        int[] target1 = {3,1,1,2};
        System.out.println(arr.minIncrements(target1));
        
        int[] target2 = {3,1,5,4,2};
        System.out.println(arr.minIncrements(target2));
    }
}