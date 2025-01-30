//Problem: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/

import java.util.*;
import java.io.*;

class MaximumGroups {
    public int countGroups(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] colors = new int[n+1];
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<Integer>());
            colors[i]=-1;
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        ArrayList<ArrayList<Integer>> components = new ArrayList<ArrayList<Integer>>();
        for(int i=1; i<=n; i++) {
            ArrayList<Integer> comp = new ArrayList<Integer>();
            if(colors[i]==-1) {
                boolean ans = isBipartite(i,colors,adj,0,comp);
                if(!ans) {
                    return -1;
                }
                components.add(comp);
            }
        }
        int totalgroups = 0;
        for(int i=0; i<components.size(); i++) {
            totalgroups+=findDepth(n,adj,components.get(i));
        }
        return totalgroups;
    }
    
    public int findDepth(int n, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> components) {
        int maxdepth=0;
        for(int i=0; i<components.size(); i++) {
            int depth=0;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            q.add(components.get(i));
            while(!q.isEmpty()) {
                int size = q.size();
                for(int j=0; j<size; j++) {
                    int node = q.poll();
                    visited[node] = true;
                    for(int m=0; m<adj.get(node).size(); m++) {
                        int child = adj.get(node).get(m);
                        if(!visited[child]) {
                            q.add(child);
                        }
                    }
                }
                depth++;
                maxdepth = Math.max(depth, maxdepth);
            }
        }
        return maxdepth;
    }
    
    public boolean isBipartite(int node, int[] colors, ArrayList<ArrayList<Integer>> adj, int col, ArrayList<Integer> components) {
        colors[node]=col;
        components.add(node);
        for(int i=0; i<adj.get(node).size(); i++) {
            int k = adj.get(node).get(i);
            if(colors[k]==-1) {
                if(isBipartite(k,colors,adj,1-col,components)==false) {
                    return false;
                }
            }
            if(colors[k]==col) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
            {1,2},{1,4},{1,5},{2,6},{2,3},{4,6}
        };
        int[][] edges1 = new int[][] {
           {67,29},{13,29},{77,29},{36,29},{82,29},{54,29},{57,29},{53,29},{68,29},{26,29},{21,29},{46,29},{41,29},{45,29},{56,29},{88,29},{2,29},{7,29},{5,29},{16,29},{37,29},{50,29},{79,29},{91,29},{48,29},{87,29},{25,29},{80,29},{71,29},{9,29},{78,29},{33,29},{4,29},{44,29},{72,29},{65,29},{61,29}
        };
        MaximumGroups graph = new MaximumGroups();
        System.out.println(graph.countGroups(6,edges));
        System.out.println(graph.countGroups(92,edges1));
    }
}