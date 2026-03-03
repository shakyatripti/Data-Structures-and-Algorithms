//Problem: https://leetcode.com/problems/minimum-cost-to-split-into-ones/



import java.io.*;
import java.util.*;

class SplitIntoOnes {
    public int minCost(int n) {
        return (n*(n-1))/2;
    }
}

class Main {
    public static void main(String[] args) {
        SplitIntoOnes num = new SplitIntoOnes();
        System.out.println(num.minCost(3));
        System.out.println(num.minCost(4));
    }
}