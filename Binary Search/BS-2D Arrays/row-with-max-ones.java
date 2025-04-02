//Problem: https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1


import java.io.*;
import java.util.*;

class RowWithMaxOnes {
    public int rowWithMax1s(int[][] arr) {
        int maxOnes=0, row=-1;
        for(int i=0; i<arr.length; i++) {
            int countOnes = arr[i].length - firstOccurence(arr[i]);
            if(countOnes > maxOnes) {
                maxOnes = countOnes;
                row = i;
            }
        }
        return row;
    }
    
    public int firstOccurence(int[] arr) {
        int l=0, r=arr.length;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(arr[mid]!=1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] arr = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        RowWithMaxOnes matrix = new RowWithMaxOnes();
        System.out.println(matrix.rowWithMax1s(arr));
        
        int[][] arr2 = {{0,0}, {0,0}};
        System.out.println(matrix.rowWithMax1s(arr2));
    }
}