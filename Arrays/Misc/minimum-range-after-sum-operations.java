//Problem:
https://leetcode.com/problems/minimum-range-after-sum-operations/description/




import java.io.*;
import java.util.*;


class SumOperations {
    public int minRange(int a, int b, int c) {
        int v1 = Math.max(b + c, Math.max(b,c));
        int v2 = Math.min(b + c, Math.min(b,c));
        int range1 = v1 - v2;

        int v3 = Math.max(a + b, Math.max(a,b));
        int v4 = Math.min(a + b, Math.min(a,b));
        int range2 = v3 - v4;

        int v5 = Math.max(a + c, Math.max(a,c));
        int v6 = Math.min(a + c, Math.min(a,c));
        int range3 = v5 - v6;

        int v7 = Math.max(a, Math.max(b,c));
        int v8 = Math.min(a, Math.min(b,c));
        int range4 = v7 - v8;

        return Math.min(range1, Math.min(range2, Math.min(range3, range4)));
    }
}

class Main {
    public static void main(String[] args) {
        SumOperations arr = new SumOperations();
        System.out.println(arr.minRange(9,2,5));
        System.out.println(arr.minRange(5,7,6));
        System.out.println(arr.minRange(3,3,3));
    }
}