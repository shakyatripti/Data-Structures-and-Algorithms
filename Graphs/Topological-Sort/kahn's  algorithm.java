//Problem: https://www.geeksforgeeks.org/problems/topological-sort/1


import java.io.*;
import java.util.*;

class KahnAlgorithm {
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = adj.size();
        int[] indegree = new int[n];
        for(int i=0; i<adj.size(); i++) {
            for(int j=0; j<adj.get(i).size(); j++) {
                int node = adj.get(i).get(j);
                indegree[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for(int i=0; i<adj.get(curr).size(); i++) {
                int node = adj.get(curr).get(i);
                indegree[node]--;
                if(indegree[node]==0) {
                    q.add(node);
                }
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        //4-->1
        adj.get(4).add(1);
        //4-->0
        adj.get(4).add(0);
        //5-->0
        adj.get(5).add(0);
        //5-->2
        adj.get(5).add(2);
        //1-->3
        adj.get(1).add(3);
        //2-->3
        adj.get(2).add(3);
        
        KahnAlgorithm graph = new KahnAlgorithm();
        ArrayList<Integer> ans = graph.topologicalSort(adj);
        for(int i: ans) {
            System.out.print(i +  " ");
        }
    }
}