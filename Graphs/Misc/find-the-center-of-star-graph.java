//Problem: https://leetcode.com/problems/find-center-of-star-graph/description/




import java.io.*;
import java.util.*;


class StarGraph {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int[] freq = new int[n+2];
        for(int i=0; i<n; i++) {
            freq[edges[i][0]]++;
            freq[edges[i][1]]++;
        }

        for(int i=0; i<=n+1; i++) {
            if(freq[i]==n) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        StarGraph graph = new StarGraph();
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(graph.findCenter(edges));
        
        int[][] edges1 = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(graph.findCenter(edges1));
    }
}