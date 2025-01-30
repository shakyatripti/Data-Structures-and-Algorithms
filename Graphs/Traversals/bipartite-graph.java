//Problem: https://leetcode.com/problems/is-graph-bipartite/description/

import java.util.*;
import java.io.*;

class BipartiteGraph {
    public boolean isBipartite(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] colors = new int[n];
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
            colors[i]=-1;
        }
        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
        }
        for(int i=0; i<n; i++) {
            if(colors[i]==-1) {
                boolean ans = findColoredComp(i,adj,colors,0);
                if(!ans) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean findColoredComp(int node, ArrayList<ArrayList<Integer>> adj, int[] colors, int col) {
        colors[node]=col;
        for(int i=0; i<adj.get(node).size(); i++) {
            int k = adj.get(node).get(i);
            if(colors[k]==-1) {
                if(findColoredComp(k,adj,colors,1-col) == false){return false;}
            }
            if(colors[k]==col) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
            {1,2,3},{0,2},{0,1,3},{0,2}
        };
        int[][] edges2 = new int[][]{
            {1,3},{0,2},{1,3},{0,2}
        };
        BipartiteGraph graph = new BipartiteGraph();
        System.out.println(graph.isBipartite(4,edges));
        System.out.println(graph.isBipartite(4,edges2));
    }
}