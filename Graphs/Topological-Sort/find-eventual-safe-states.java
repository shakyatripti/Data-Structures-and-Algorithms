//Problem: https://leetcode.com/problems/find-eventual-safe-states/description/

import java.util.*;
import java.io.*;

class FindSafeNodes {
    public List<Integer> countSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<Integer> safeNodes = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
            if(graph[i].length == 0) {
                q.add(i);
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<graph[i].length; j++) {
                int k = graph[i][j];
                adj.get(k).add(i);
                indegree[i]++;
            }
        }
        while(!q.isEmpty()) {
            int t = q.poll();
            safeNodes.add(t);
            for(int i=0; i<adj.get(t).size(); i++) {
                int k = adj.get(t).get(i);
                indegree[k]--;
                if(indegree[k] == 0) {
                    q.add(k);
                }
            }
        } 
        Collections.sort(safeNodes);
        return safeNodes;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] graph = new int[][] {
            {},{0,2,3,4},{3},{4},{}
        };
        int[][] graph1 = new int[][] {
            {1,2},{2,3},{5},{0},{5},{},{}
        };
        FindSafeNodes events = new FindSafeNodes();
        List<Integer> ans = events.countSafeNodes(graph);
        List<Integer> ans1 = events.countSafeNodes(graph1);
        for(int element: ans) {
            System.out.print(element + " ");
        }
        System.out.print("\n");
        for(int element: ans1) {
            System.out.print(element+ " ");
        }
    }
}