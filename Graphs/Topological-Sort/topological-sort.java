//Problem: https://www.geeksforgeeks.org/problems/topological-sort/1

import java.util.*;
import java.io.*;

class TopologicalSort {
    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++) {
            if(!visited[i]) {
                findDfs(i,adj,visited,st);
            }
        }
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }
    
    public void findDfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        for(int i=0; i<adj.get(node).size(); i++) {
            int k = adj.get(node).get(i);
            if(!visited[k]) {
                findDfs(k, adj,visited,st);
            }
        }
        st.push(node);
        visited[node] = true;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<5; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        //Edge 0-->1
        adj.get(0).add(1);
        //Edge 1-->3
        adj.get(1).add(3);
        //Edge 2-->4
        adj.get(2).add(4);
        //Edge 3-->4
        adj.get(3).add(4);
        TopologicalSort graph = new TopologicalSort();
        ans = graph.topoSort(adj);
        for(int i=0; i<ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        
        
    }
}