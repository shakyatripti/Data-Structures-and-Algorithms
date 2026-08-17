//Problem: https://leetcode.com/problems/xor-operation-in-an-array/description/




import java.io.*;
import java.util.*;

class XORInArray {
    public int operation(int n, int start) {
        int sum = 0;
        int[] nums = new int[n+1];
        for(int i=0; i<n; i++) {
            nums[i] = start + 2 * i;
        }

        for(int i=0; i<n; i++) {
            sum^=nums[i];
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        XORInArray arr = new XORInArray();
        System.out.println(arr.operation(5, 0));
        System.out.println(arr.operation(4, 3));
    }
}