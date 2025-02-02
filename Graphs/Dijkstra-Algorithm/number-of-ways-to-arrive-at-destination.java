//Problem: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

import java.util.*;
import java.io.*;

class NumberOfWaysToDestination  {
    public int countPaths(int n, int[][] roads) {
        int[] distance = new int[n];
        int[] paths = new int[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
            distance[i]=Integer.MAX_VALUE;
            paths[i]=0;
        }
        for(int i=0; i<roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
        int mod = (int) (1e9 + 7);
        q.add(new Pair(0,0));
        paths[0]=1;
        while(!q.isEmpty()) {
            Pair t = q.poll();
            int node = t.node;
            int dist = t.distance;
            for(int i=0; i<adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).node;
                int adjWt = adj.get(node).get(i).distance;
                if(dist + adjWt < distance[adjNode]) {
                    distance[adjNode] = dist + adjWt;
                    q.add(new Pair(adjNode, distance[adjNode]));
                    paths[adjNode] = paths[node];
                } else if(dist + adjWt == distance[adjNode]) {
                    paths[adjNode] = (paths[adjNode] + paths[node]) % mod;
                }
            }
        }
        return paths[n-1] % mod;
    }
}

class Pair {
    int node;
    int distance;
    Pair(int n, int d) {
        node = n;
        distance = d;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] roads = new int[][] {
             {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}

        };
        NumberOfWaysToDestination graph = new NumberOfWaysToDestination();
        System.out.println(graph.countPaths(7,roads));
    }
}
