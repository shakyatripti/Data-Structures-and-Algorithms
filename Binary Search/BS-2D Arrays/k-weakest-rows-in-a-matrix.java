//Problem: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/



import java.io.*;
import java.util.*;

class KWeakestRows {
    public int[] weakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)-> {
            if(x[0]!=y[0]) { return Integer.compare(x[0], y[0]); }
            return Integer.compare(x[1], y[1]);
        });
        for(int i=0; i<mat.length; i++) {
            int ones = countOnes(mat[i]);
            pq.add(new int[]{ones, i});
        }
        int[] ans = new int[k];
        int j=0;
        while(k!=0) {
            int[] rows = pq.poll();
            ans[j] = rows[1];
            k--;
            j++;
        }
        return ans;
    }
    
    public int countOnes(int[] mat) {
        int l=0, r=mat.length;
        while(l<r) {
            int mid = (l+r)/2;
            if(mat[mid]==0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        KWeakestRows rows = new KWeakestRows();
        int[] ans = rows.weakestRows(mat, 3);
        rows.display(ans);
        
        int[][] mat2 = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int[] ans2 = rows.weakestRows(mat2, 2);
        rows.display(ans2);
    }
}