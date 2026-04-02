//Problem:



import java.io.*;
import java.util.*;

class HeightChecker {
    public int numberOfIndices(int[] heights) {
        int n=heights.length, count=0;
        int[] copyHeights = new int[n];
        for(int i=0; i<n; i++) {
            copyHeights[i] = heights[i];
        }
        Arrays.sort(copyHeights);
        for(int i=0; i<n; i++) {
            if(copyHeights[i]!=heights[i]) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        HeightChecker arr = new HeightChecker();
        int[] heights = {1,1,4,2,1,3};
        System.out.println(arr.numberOfIndices(heights));
        
        int[] heights1 = {5,1,2,3,4};
        System.out.println(arr.numberOfIndices(heights1));
        
        int[] heights2 = {1,2,3,4,5};
        System.out.println(arr.numberOfIndices(heights2));
    }
}