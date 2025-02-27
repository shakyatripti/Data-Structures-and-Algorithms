//Problem: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/


import java.io.*;
import java.util.*;

class AncestorsInDAG {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        for(int i=0; i<n; i++) {
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            findDFS(i,i,adj,ans,visited);
        }
        
        return ans;
    }
    
    public void findDFS(int node, int parent, List<List<Integer>> adj, List<List<Integer>> ans, boolean[] visited) {
        visited[parent] = true;
        for(int i=0; i<adj.get(parent).size(); i++) {
            int childNode = adj.get(parent).get(i);
            if(!visited[childNode]) {
                ans.get(childNode).add(node);
                findDFS(node,childNode,adj,ans,visited);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        AncestorsInDAG ancestors = new AncestorsInDAG();
        List<List<Integer>> ans = ancestors.getAncestors(8, edges);
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                int k = ans.get(i).get(j);
                System.out.println(k + " ");
            }
            System.out.print("\n");
        }
    }
}