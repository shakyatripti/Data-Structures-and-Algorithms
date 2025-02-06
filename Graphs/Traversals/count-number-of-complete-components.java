//Problem: https://leetcode.com/problems/count-the-number-of-complete-components/description/

import java.util.*;
import java.io.*;

class CountCompleteComponents {
    public int completeComponents(int n, int[][] edges) {
        if(edges.length==0) {
            return n;
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        int count=0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                if(isCompleteComponent(i,adj,visited,indegree)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isCompleteComponent(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] indegree) {
        int vertices = 0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> comp = new ArrayList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            vertices++;
            comp.add(curr);
            for(int i=0; i<adj.get(curr).size(); i++) {
                int k = adj.get(curr).get(i);
                if(!visited[k]) {
                    q.add(k);
                    visited[k] = true;
                }
            }
        }
        for(int i=0; i<comp.size(); i++) {
            if(indegree[comp.get(i)]!=vertices-1) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        int[][] edges2 = {{1,0},{2,0},{3,1},{3,2}};
        int[][] edges3 = {};
        CountCompleteComponents comp = new CountCompleteComponents();
        System.out.println(comp.completeComponents(6,edges));
        System.out.println(comp.completeComponents(4,edges2));
        System.out.println(comp.completeComponents(2,edges3));
    }
}