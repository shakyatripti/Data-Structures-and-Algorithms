//Problem: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

import java.util.*;
import java.io.*;

class CycleDetection {
    public boolean isCyclic(ArrayList<ArrayList<Integer>>adj) {
        boolean ans = false;
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<adj.size(); i++) {
            if(!visited[i]) {
                q.add(i);
                ans = findBfs(q,visited,adj);
            }
            if(ans) {
                return ans;
            }
        }
        return ans;
    }
    
    public boolean findBfs(Queue<Integer>q, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int s = q.poll();
                if(visited[s]) {
                    return true;
                }
                for(int j=0; j<adj.get(s).size(); j++) {
                    int k = adj.get(s).get(j);
                    if(!visited[k]) {
                        q.add(k);
                    }
                }
                visited[s] = true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<5; i++) {
            adj.add(new ArrayList<Integer>());
        }
        //Edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);
        
        //Edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);
        
        //Edge 2---3
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        //Edge 3---4
        adj.get(3).add(4);
        adj.get(4).add(3);
        
        //Edge 1---4
        adj.get(4).add(1);
        adj.get(1).add(4);
        CycleDetection graph = new CycleDetection();
        System.out.println(graph.isCyclic(adj));
        
    }
}