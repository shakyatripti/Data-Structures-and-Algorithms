//Problem: https://leetcode.com/problems/shortest-cycle-in-a-graph/description/


import java.io.*;
import java.util.*;

class ShortestCycleInGraph {
    public int shortestCycle(int n, int[][] edges) {
        int len = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            q.add(i);
            dist[i] = 0;
            while(!q.isEmpty()) {
                int curr = q.poll();
                for(int j=0; j<adj.get(curr).size(); j++) {
                    int node = adj.get(curr).get(j);
                    if(dist[node]==-1) {
                        dist[node] = 1 + dist[curr];
                        q.add(node);
                    } else if(node!=i && dist[node] >= dist[curr]) {
                        len = Math.min((dist[node] + dist[curr] + 1), len);
                    }
                }
            }
        }
        
        return len==Integer.MAX_VALUE ? -1 : len;
    }
}


class Main {
    public static void main(String[] args) {
        int[][] edges = {{1,3},{3,5},{5,7},{7,1},{0,2},{2,4},{4,0},{6,0},{6,1}};
        ShortestCycleInGraph cycle = new ShortestCycleInGraph();
        System.out.println(cycle.shortestCycle(8, edges));
        
        int[][] edges2 = {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
        System.out.println(cycle.shortestCycle(7, edges2));
        
        int[][] edges3 = {{0,1},{0,2}};
        System.out.println(cycle.shortestCycle(4, edges3));
    }
}