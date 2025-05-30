//Problem: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/




import java.io.*;
import java.util.*;

class ClosestNode {
    public int minDistance(int[] edges, int node1, int node2) {
        if(node1==node2) {
            return node1;
        }
        int ans=-1, n=edges.length, maxDist=Integer.MAX_VALUE;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        calculateDist(edges, node1, dist1);
        calculateDist(edges, node2, dist2);
        
        for(int i=0; i<n; i++) {
            int totalDist = Math.max(dist1[i], dist2[i]);
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE) {
                if(totalDist < maxDist) {
                    maxDist = totalDist;
                    ans = i;
                }
            }
        }
        return ans;
    }
    
    public void calculateDist(int[] edges, int node, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        q.add(node);
        visited[node] = true;
        dist[node] = 0;
        while(!q.isEmpty()) {
            int topNode = q.poll();
            int adjNode = edges[topNode];
            if(adjNode!=-1 && !visited[adjNode]) {
                q.add(adjNode);
                visited[adjNode] = true;
                dist[adjNode] = 1 + dist[topNode];
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        ClosestNode node = new ClosestNode();
        int[] edges = {2,2,3,-1};
        System.out.println(node.minDistance(edges, 0, 1));
        
        int[] edges1 = {9,8,7,0,5,6,1,3,2,2};
        System.out.println(node.minDistance(edges1, 1, 6));
        
        int[] edges2 = {5,3,1,0,2,4,5};
        System.out.println(node.minDistance(edges2, 3, 2));
        
        int[] edges3 = {5,4,5,4,3,6,-1};
        System.out.println(node.minDistance(edges3, 0, 1));
    }
}