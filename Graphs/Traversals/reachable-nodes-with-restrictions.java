//Problem: https://leetcode.com/problems/reachable-nodes-with-restrictions/description/?envType=problem-list-v2&envId=tree

import java.util.*;
import java.io.*;

class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][]edges, int[]restricted) {
        int r=edges.length, c= edges[0].length, ans=0;
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<restricted.length; i++) {
            int restrict = restricted[i];
            visited[restrict] = -1;
        }
        for(int i=0; i<r; i++) {
            if(visited[i]!=-1) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        q.add(0);
        visited[0] = 1;
        while(!q.isEmpty()) {
            int p = q.poll();
            ans++;
            for(int i=0; i<adj.get(p).size(); i++) {
                int k = adj.get(p).get(i);
                if(visited[k]!=1) {
                    q.add(k);
                    visited[k] = 1;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
            {0,1},{0,2},{0,5},{0,4},{3,2},{6,5}
        };
        int[] restricted = new int[]{4,2,1};
        ReachableNodesWithRestrictions nodes = new ReachableNodesWithRestrictions();
        System.out.println(nodes.reachableNodes(7,edges,restricted));
    }
}