//Problem: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

import java.util.*;
import java.io.*;

class DijkstraAlgorithm {
    public ArrayList<Integer> shortestPathFromSource(ArrayList<ArrayList<Pair>> adj, int src) {
        int[] distance = new int[adj.size()];
        for(int i=0; i<adj.size(); i++){
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        q.add(new Pair(src,0));
        distance[src]=0;
        while(!q.isEmpty()) {
            Pair path = q.poll();
            int dist = path.distance;
            int node = path.node;
            for(int i=0; i<adj.get(node).size(); i++) {
                int adjWeight = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;
                if((dist + adjWeight) < distance[adjNode]) {
                    distance[adjNode] = dist + adjWeight;
                    q.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<distance.length; i++) {
            ans.add(distance[i]);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<6; i++) {
            adj.add(new ArrayList<Pair>());
        }
        //Edge 0---1 with weight 4
        adj.get(0).add(new Pair(1,4));
        adj.get(1).add(new Pair(0,4));
        
        //Edge 0---2 with weight 4
        adj.get(0).add(new Pair(2,4));
        adj.get(2).add(new Pair(0,4));
        
        //Edge 1---2 with weight 2
        adj.get(1).add(new Pair(2,2));
        adj.get(2).add(new Pair(1,2));
        
        //Edge 2---3 with weight 3
        adj.get(2).add(new Pair(3,3));
        adj.get(3).add(new Pair(2,3));
        
        //Edge 2---4 with weight 1
        adj.get(2).add(new Pair(4,1));
        adj.get(4).add(new Pair(2,1));
        
        //Edge 2---5 with weight 6
        adj.get(2).add(new Pair(5,6));
        adj.get(5).add(new Pair(2,6));
        
        //Edge 3---5 with weight 2
        adj.get(3).add(new Pair(5,2));
        adj.get(5).add(new Pair(3,2));
        
        //Edge 4---5 with weight 3
        adj.get(4).add(new Pair(5,3));
        adj.get(5).add(new Pair(4,3));
        
        DijkstraAlgorithm graph = new DijkstraAlgorithm();
        ArrayList<Integer> ans = graph.shortestPathFromSource(adj, 0);
        for(int dist: ans) {
            System.out.print(dist + " ");
        }
    }
}

class Pair {
    int node;
    int distance;
    Pair(int n, int dist) {
        distance = dist;
        node = n;
    }
}