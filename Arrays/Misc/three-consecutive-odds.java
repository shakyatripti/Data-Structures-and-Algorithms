//Problem: https://leetcode.com/problems/three-consecutive-odds/description/



import java.io.*;
import java.util.*;

class ThreeConsecutiveOdds {
    public boolean consecutiveOdds(int[] arr) {
        for(int i=0; i<=arr.length-3; i++) {
            int firstNum = arr[i];
            int secondNum = arr[i+1];
            int thirdNum = arr[i+2];
            if(firstNum%2!=0 && secondNum%2!=0 && thirdNum%2!=0) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ThreeConsecutiveOdds obj = new ThreeConsecutiveOdds();
        int[] arr = {2,6,4,1};
        System.out.println(obj.consecutiveOdds(arr));
        
        int[] arr1 = {1,2,34,3,4,5,7,23,12};
        System.out.println(obj.consecutiveOdds(arr1));
        
        int[] arr2 = {2,7,11,14,15,3,21};
        System.out.println(obj.consecutiveOdds(arr2));
    }
}