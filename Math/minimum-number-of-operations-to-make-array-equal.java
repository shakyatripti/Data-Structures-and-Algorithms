//Problem: https://leetcode.com/problems/minimum-operations-to-make-array-equal/description/





import java.io.*;
import java.util.*;

class MakeArrayEqual {
    public int minOperations(int n) {
        int sum = 1, target = 0, ans = 0;
        for(int i=1; i<n; i++) {
            sum+= 2 * i + 1;
        }
        target = sum/n;
        for(int i=0; i<n; i++) {
            int val = 2*i+1;
            if(val!=target) {
                ans+=Math.abs(val - target);
            }
        }
        return ans/2;
    }
}

class Main {
    public static void main(String[] args) {
        MakeArrayEqual arr = new MakeArrayEqual();
        System.out.println(arr.minOperations(3));
        System.out.println(arr.minOperations(6));
    }
}