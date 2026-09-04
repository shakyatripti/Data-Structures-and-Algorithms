//Problem: https://leetcode.com/problems/add-minimum-number-of-rungs/description/




import java.io.*;
import java.util.*;


class AddRungs {
    public int findMinNum(int[] rungs, int dist) {
        int res = (rungs[0] - 1) / dist;
        for (int i = 1; i < rungs.length; ++i) {
            res += (rungs[i] - rungs[i - 1] - 1) / dist;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        AddRungs arr = new AddRungs();
        int[] rungs = {1,3,5,10};
        System.out.println(arr.findMinNum(rungs, 2));
        
        int[] rungs1 = {3,6,8,10};
        System.out.println(arr.findMinNum(rungs1, 3));
        
        int[] rungs2 = {3,4,6,7};
        System.out.println(arr.findMinNum(rungs2, 2));
        
        int[] rungs3 = {3};
        System.out.println(arr.findMinNum(rungs3, 1));
    }
}