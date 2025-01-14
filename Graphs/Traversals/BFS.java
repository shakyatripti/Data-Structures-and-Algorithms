//Problem: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.*;
import java.io.*;

class BFSInGraph {
    public List<Integer> bfsTraversal(int V, ArrayList<ArrayList<Integer>> adj){
        boolean [] visited = new boolean[adj.size()];
        Arrays.fill(visited, Boolean.FALSE);
        List<Integer> traversal = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()) {
           int topVertex = q.poll();
           for(int i=0; i<adj.get(topVertex).size(); i++) {
               if(visited[adj.get(topVertex).get(i)] == false) {
                 q.add(adj.get(topVertex).get(i));
                 visited[adj.get(topVertex).get(i)] = true;
               }
           }
           traversal.add(topVertex);
        }
        return traversal;
    }
    
    public void adjacencyList(int v, int u, ArrayList<ArrayList<Integer>> adj){
        adj.get(v).add(u);
        adj.get(u).add(v);
    }
}

class Main {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        BFSInGraph graph = new BFSInGraph();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        //Edge 0---2
        graph.adjacencyList(0,2,adj);
        //Edge 0---3
        graph.adjacencyList(0,3,adj);
        //Edge 0---1
        graph.adjacencyList(0,1,adj);
        //Edge 2---4
        graph.adjacencyList(2,4,adj);
        List<Integer> traversal = graph.bfsTraversal(V, adj);
        for(int val: traversal) {
            System.out.println(val);
        }
    }
}