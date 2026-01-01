//Problem: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/





import java.io.*;
import java.util.*;

class ArithmeticProgression {
    public boolean canMake(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i=1; i<arr.length; i++) {
            if((arr[i] - arr[i-1])!=diff) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ArithmeticProgression num = new ArithmeticProgression();
        int[] arr = {3,5,1};
        System.out.println(num.canMake(arr));
        
        int[] arr1 = {1,2,4};
        System.out.println(num.canMake(arr1));
    }
}