//Problem: https://leetcode.com/problems/minimize-maximum-component-cost/description/




/*Brute Force Solution: Use binary search from 0 to maxWeight, and count components for the graph after eliminating those edges
    whose weight is greater than mid. If components count is greater than k, we need to increase the mid value, otherwise decrease 
    the mid value.
*/

import java.io.*;
import java.util.*;

class MinMaxComponentCost {
    public int minCost(int n, int[][] edges, int k) {
        int maxWeight=0;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            int[] val = new int[]{edges[i][1], edges[i][2]};
            int[] val2 = new int[]{edges[i][0], edges[i][2]};
            adj.get(edges[i][0]).add(val);
            adj.get(edges[i][1]).add(val2);
            maxWeight = Math.max(maxWeight, edges[i][2]);
        }
        int l=0, r=maxWeight, ans=0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(isPossible(adj, mid, k, n)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(ArrayList<ArrayList<int[]>> adj, int mid, int k, int n) {
        boolean[] visited = new boolean[n];
        int comp = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                countComponents(i, adj, visited, mid);
                comp++;
            }
            if(comp > k) {
                return false;
            }
        }
        return true;
    }

    public void countComponents(int node, ArrayList<ArrayList<int[]>> newAdj, boolean[] visited, int mid) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        for(int[] adjNode: newAdj.get(node)) {
            if(!visited[adjNode[0]] && adjNode[1] <= mid) {
                countComponents(adjNode[0], newAdj, visited, mid);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MinMaxComponentCost graph = new MinMaxComponentCost();
        int[][] edges = {{0,1,4},{1,2,3},{1,3,2},{3,4,6}};
        System.out.println(graph.minCost(5, edges, 2));
        
        int[][] edges1 = {{0,1,5},{1,2,5},{2,3,5}};
        System.out.println(graph.minCost(4, edges1, 1));
        
        int[][] edges2 = {{0,1,80},{0,2,6},{1,2,46}};
        System.out.println(graph.minCost(3, edges2, 1));
        
        int[][] edges3 = {{0,1,5},{1,2,5},{2,3,5}};
        System.out.println(graph.minCost(4, edges3, 4));
        
    }
}