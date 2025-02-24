//Problem: https://leetcode.com/problems/most-profitable-path-in-a-tree/description/


import java.io.*;
import java.util.*;

class MostProfitablePath {
    int profit = Integer.MIN_VALUE;
    public int mostProfit(int[][] edges, int bob, int[] amount) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        pathByBob(bob,0,adj,visited,mp);
        Arrays.fill(visited, false);
        scoreOfAlice(0,0,adj,visited,amount,0,mp);
        return profit;
    }
    
    public boolean pathByBob(int node, int time, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
     HashMap<Integer, Integer> mp) {
        visited[node] = true;
        mp.put(node, time);
        
        if(node == 0) {
            return true;
        }
        
        for(int i=0; i<adj.get(node).size(); i++) {
            int path = adj.get(node).get(i);
            if(!visited[path] && pathByBob(path, time+1, adj,visited, mp)) {
                return true;
            }
        }
        
        mp.remove(node);
        return false;
    }
    
    public void scoreOfAlice(int node, int time, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
     int[] amount, int income, HashMap<Integer, Integer> mp) {
        visited[node] = true;
        if(!mp.containsKey(node) || time < mp.get(node)) {
            income+=amount[node];
        } else if(mp.get(node)==time) {
            income+=amount[node]/2;
        }
        
        if(adj.get(node).size()==1 && node!=0) {
            profit = Math.max(profit, income);
        }
        
        for(int i=0; i<adj.get(node).size(); i++) {
            int path = adj.get(node).get(i);
            if(!visited[path]) {
                scoreOfAlice(path, time+1, adj, visited, amount, income, mp);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        int[] amount = {-2,4,2,-4,6};
        MostProfitablePath path = new MostProfitablePath();
        System.out.println(path.mostProfit(edges,3,amount));
    }
}