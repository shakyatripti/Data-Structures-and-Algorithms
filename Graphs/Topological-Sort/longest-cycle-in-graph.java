//Problem: https://leetcode.com/problems/longest-cycle-in-a-graph/description/


import java.io.*;
import java.util.*;

class LongestCycleInGraph {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        Arrays.fill(indegree, 0);
        
        for(int i=0; i<n; i++) {
            if(edges[i]!=-1) {
                indegree[edges[i]]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            int adjNode = edges[node];
            if(adjNode!=-1) {
                indegree[adjNode]--;
                if(indegree[adjNode]==0) {
                    q.add(adjNode);
                }
            }
        }
        
        int len = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(indegree[i]!=0 && !visited[i]) {
                len = Math.max(countNodesInCycle(i,edges,visited), len);
            }
        }
        
        return len==Integer.MIN_VALUE ? -1 : len;
    }
    
    public int countNodesInCycle(int node, int[] edges, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int count = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            int adjNode = edges[curr];
            if(visited[adjNode]) {
                return count;
            }
            count++;
            if(adjNode!=-1) {
                q.add(adjNode);
            }
            visited[curr] = true;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int[] edges = {3,3,4,2,3};
        LongestCycleInGraph cycle = new LongestCycleInGraph();
        System.out.println(cycle.longestCycle(edges));
        
        int[] edges2 = {1,2,0,4,5,6,3,8,9,7};
        System.out.println(cycle.longestCycle(edges2));
        
        int[] edges3 = {2,-1,3,1};
        System.out.println(cycle.longestCycle(edges3));
    }
}