//Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/description/




import java.io.*;
import java.util.*;

class PathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int id=0;
        int[] component = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
            component[i] = -1;
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0; i<n; i++) {
            if(component[i]==-1) {
                findBFS(i, adj, component, id);
            }
            id++;
        }
        if(component[source]==component[destination]) {
            return true;
        }
        return false;
    }
    
    public void findBFS(int node, ArrayList<ArrayList<Integer>> adj, int[] component, int id) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        component[node] = id;
        while(!q.isEmpty()) {
            int topNode = q.poll();
            for(int i=0; i<adj.get(topNode).size(); i++) {
                int adjNode = adj.get(topNode).get(i);
                if(component[adjNode]==-1) {
                    q.add(adjNode);
                    component[adjNode] = id;
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        PathExists graph = new PathExists();
        int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println(graph.validPath(3, edges, 0, 2));
        
        int[][] edges1 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(graph.validPath(6, edges1, 0, 5));
        
        int[][] edges2 = {{0,2}, {1,3}};
        System.out.println(graph.validPath(4, edges2, 0, 3));
    }
}