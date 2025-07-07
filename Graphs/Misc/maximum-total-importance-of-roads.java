//Problem: https://leetcode.com/problems/maximum-total-importance-of-roads/description/




import java.io.*;
import java.util.*;

class ImportanceOfRoads {
    public long maxTotal(int n, int[][] roads) {
        long ans=0, val=1;
        int[] indegree = new int[n];
        for(int i=0; i<roads.length; i++) {
            indegree[roads[i][0]]++;
            indegree[roads[i][1]]++;
        }
        Arrays.sort(indegree);
        for(int i=0; i<n; i++) {
            ans+=indegree[i]*val;
            val++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ImportanceOfRoads importance = new ImportanceOfRoads();
        int[][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        System.out.println(importance.maxTotal(5, roads));
        
        int[][] roads1 = {{0,3},{2,4},{1,3}};
        System.out.println(importance.maxTotal(5, roads1));
    }
}