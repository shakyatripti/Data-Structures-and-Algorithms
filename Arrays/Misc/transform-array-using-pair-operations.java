//Problem: https://leetcode.com/problems/transform-array-using-pair-operations/description/




import java.io.*;
import java.util.*;

class PairOperations {
    public boolean canTransform(int[] source, int[] target) {
        long sum=0, sum1=0;
        for(int i=0; i<source.length; i++) {
            sum+=source[i];
        }

        for(int i=0; i<target.length; i++) {
            sum1+=target[i];
        }

        if(sum==sum1) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        PairOperations arr = new PairOperations();
        int[] source = {1,2,3};
        int[] target = {0,2,4};
        System.out.println(arr.canTransform(source, target));
        
        int[] source1 = {-5,-5};
        int[] target1 = {-15,5};
        System.out.println(arr.canTransform(source1, target1));
        
        int[] source2 = {1,2,1};
        int[] target2 = {0,2,5};
        System.out.println(arr.canTransform(source2, target2));
        
        int[] source3 = {1000000000,1000000000,1000000000,1000000000,294967296};
        int[] target3 = {0,0,0,0,0};
        System.out.println(arr.canTransform(source3, target3));
    }
}