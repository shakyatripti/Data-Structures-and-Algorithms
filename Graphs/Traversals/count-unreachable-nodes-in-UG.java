//Problem: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

import java.util.*;
import java.io.*;

class CountUnreachableNodes {
    public Long unreachableNode(int n, int[][] edges) {
        Long reachablePairs = 0L;
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                Long size = findConnectedNodes(i,adj,visited);
                reachablePairs+=size * (size - 1) / 2;
            }
        }
        Long totalPairs = (long) n * (n - 1) / 2;
        Long ans = totalPairs - reachablePairs;
        return ans > 0 ? ans : 0;
        
    }
    
    public Long findConnectedNodes(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        Long size = 1L;
        while(!q.isEmpty()) {
            int t = q.poll();
            for(int i=0; i<adj.get(t).size(); i++) {
                int k = adj.get(t).get(i);
                if(!visited[k]) {
                    visited[k] = true;
                    size++;
                    q.add(k);
                }
            }
        }
        return size;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
            {0,2},{0,5},{2,4},{1,6},{5,4}
        };
        CountUnreachableNodes graph = new CountUnreachableNodes();
        System.out.println(graph.unreachableNode(7, edges));
    }
}