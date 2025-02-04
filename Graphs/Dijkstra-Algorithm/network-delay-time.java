//Problem: https://leetcode.com/problems/network-delay-time/description/

import java.util.*;
import java.io.*;

class NetworkDelayTime {
    public int delayTime(int[][] times, int n, int k) {
        int[] distance = new int[n+1];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<=n; i++) {
            distance[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k,0));
        distance[k]=distance[0]=0;
        while(!q.isEmpty()) {
            Pair time = q.poll();
            int dist = time.state;
            int signal = time.node;
            for(int i=0; i<adj.get(signal).size(); i++) {
                int adjWt = adj.get(signal).get(i).state;
                int adjNode = adj.get(signal).get(i).node;
                if(distance[adjNode] > adjWt + dist) {
                    distance[adjNode] = adjWt + dist;
                    q.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        int ans=-1;
        for(int i=0; i<distance.length; i++) {
            ans = Math.max(ans, distance[i]);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}

class Pair {
    int state;
    int node;
    Pair(int n, int s) {
        state = s;
        node = n;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] times = new int[][] {
            {2,1,1},{2,3,1},{3,4,1}
        };
        int[][] times2 = new int[][] {
            {2,1,1},{2,3,2},{3,4,1},{3,5,5},{4,5,1},{5,6,1}
        };
        int[][] times3 = new int[][]{{1,2,1}};
        NetworkDelayTime network = new NetworkDelayTime();
        System.out.println(network.delayTime(times,4,2));
        System.out.println(network.delayTime(times2,6,2));
        System.out.println(network.delayTime(times3,2,2));
    }
}