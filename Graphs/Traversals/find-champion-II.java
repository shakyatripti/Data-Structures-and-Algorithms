//Problem: https://leetcode.com/problems/find-champion-ii/description/


import java.io.*;
import java.util.*;

class FindChampion {
    public int champion(int n, int[][] edges) {
        int[] indegree = new int[n];
        Arrays.fill(indegree, 0);
        int count = 0, champion = -1;
        for(int i=0; i<edges.length; i++) {
            indegree[edges[i][1]]++;
        }
        
        for(int i=0; i<n; i++) {
            if(indegree[i]==0) {
                count++;
                champion = i;
            }
        }
        
        return count==1 ? champion : -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,2},{1,3},{1,2}};
        FindChampion ans = new FindChampion();
        System.out.println(ans.champion(4, edges));
        
        int[][]  edges2 = {{0,1},{1,2}};
        System.out.println(ans.champion(3, edges2));
    }
}