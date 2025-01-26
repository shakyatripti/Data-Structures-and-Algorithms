//Problem: https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

import java.util.*;
import java.io.*;

class NetworkConnected {
    public int numberOfOperations(int n, int[][] connections) {
        int operations = 0;
        if(connections.length < n-1) {
            return -1;
        }
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                operations++;
                q.add(i);
                visited[i] = true;
                findClusters(q, adj, visited);
            }
        }
        return operations-1;
    }
    
    public void findClusters(Queue<Integer> q, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int t = q.poll();
                for(int j=0; j<adj.get(t).size(); j++) {
                    int k = adj.get(t).get(j);
                    if(!visited[k]) {
                        visited[k] = true;
                        q.add(k);
                    }
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] connections = new int[][]{
            {0,1},{0,2},{0,3},{1,2},{1,3},{2,4},{4,5},{4,3},{5,2}
        };
        int[][] connections1 = new int[][] {
            {0,1},{0,2},{2,3}
        };
        NetworkConnected network = new NetworkConnected();
        System.out.println(network.numberOfOperations(10, connections));
        System.out.println(network.numberOfOperations(6, connections1));
    }
}