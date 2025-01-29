//Problem: https://leetcode.com/problems/redundant-connection/description/

import java.util.*;
import java.io.*;

class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<Integer>());
            indegree[i] = 0;
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        for(int i=0; i<n; i++) {
            if(indegree[i]==1) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int t = q.poll();
            for(int i=0; i<adj.get(t).size(); i++) {
                int k = adj.get(t).get(i);
                indegree[k]--;
                if(indegree[k]==1) {
                    q.add(k);
                }
            }
        }
        HashSet<Integer> connections = new HashSet<Integer>();
        for(int i=0; i<n; i++) {
            if(indegree[i] > 1) {
                connections.add(i);
            }
        }
        for(int i= edges.length-1; i>=0; i--) {
            if(connections.contains(edges[i][0]) && connections.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return edges[0];
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
            {1,2},{2,3},{3,4},{1,4},{1,5}
        };
        RedundantConnection graph = new RedundantConnection();
        int[] connections = graph.findRedundantConnection(edges);
        System.out.print(connections[0] + " " + connections[1]);
    }
}