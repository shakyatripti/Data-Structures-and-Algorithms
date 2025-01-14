//Problem: https://leetcode.com/problems/number-of-provinces/description/

import java.util.*;
import java.io.*;

class NumberOfProvinces {
    public int countProvinces(int[][]isConnected) {
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, Boolean.FALSE);
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i]) {
                findDfs(isConnected, i, visited);
                provinces++;
            }
        }
        return provinces;
    }
    
    public void findDfs(int[][]isConnected, int node, boolean[] visited) {
        visited[node] = true;
        for(int i=0; i<isConnected[node].length; i++) {
            int n = isConnected[node][i];
            if(!visited[i] && n==1) {
                findDfs(isConnected, i, visited);
            }
        }
    }
    
    public void adjacencyList(int v, int u, int[][]adj, boolean connected) {
        if(connected) {
           adj[v][u] = 1;
           adj[u][v] = 1;
        } else {
            adj[v][u] = 0;
            adj[u][v] = 0;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int v = 3;
        int[][] isConnected = new int[v][v];
        NumberOfProvinces graph = new NumberOfProvinces();
        graph.adjacencyList(0,0,isConnected, true);
        graph.adjacencyList(0,1,isConnected, true);
        graph.adjacencyList(0,2,isConnected, false);
        graph.adjacencyList(1,1,isConnected, true);
        graph.adjacencyList(2,1,isConnected, false);
        graph.adjacencyList(2,2,isConnected, true);
        System.out.println(graph.countProvinces(isConnected));
        
        
    }
}