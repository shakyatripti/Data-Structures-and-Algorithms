//Problem: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/


import java.util.*;
import java.io.*;

class SmallestNumberNeighbours {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int ans = Integer.MAX_VALUE, count = Integer.MIN_VALUE;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        for(int i=0; i<n; i++) {
            int cityDistance = shortestPath(n,i,adj,threshold);
            if(cityDistance <= ans) {
                ans = cityDistance;
                count = Math.max(i, count);
            }
        }
        return count;
    }
    
    public int shortestPath(int n, int source, ArrayList<ArrayList<Pair>> adj, int threshold) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance-y.distance);
        pq.add(new Pair(source,0));
        distance[source]=0;
        while(!pq.isEmpty()) {
            Pair cities = pq.poll();
            int dist = cities.distance;
            int city = cities.city;
            for(int i=0; i<adj.get(city).size(); i++) {
                Pair neighbour = adj.get(city).get(i);
                int neighbourDist = neighbour.distance;
                int neighbourCity = neighbour.city;
                if(distance[neighbourCity] > neighbourDist + dist) {
                    distance[neighbourCity] = neighbourDist + dist;
                    pq.add(new Pair(neighbourCity, distance[neighbourCity]));
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(distance[i]>0 && distance[i]<=threshold) {
                count++;
            }
        }
        return count;
    }
}

class Pair {
    int city;
    int distance;
    Pair(int c, int d) {
        city = c;
        distance = d;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        SmallestNumberNeighbours neighbours = new SmallestNumberNeighbours();
        System.out.println(neighbours.findTheCity(4,edges,4));
    }
}