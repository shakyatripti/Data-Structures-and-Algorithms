//Problem: https://leetcode.com/problems/node-with-highest-edge-score/description/


//Brute Force solution
import java.io.*;
import java.util.*;

class HighestEdgeScore {
    public int edgeScore(int[] edges) {
        long score = -1L, ans = 0L;
        HashMap<Integer, Long> mp = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            mp.put(edges[i], mp.getOrDefault(edges[i], 0L) + i);
        }
        for(Map.Entry entry: mp.entrySet()) {
            long val = (long) entry.getValue();
            int key = (int) entry.getKey();
            if(score < val) {
                score = val;
                ans = key;
            } else if(score==val) {
                ans=Math.min(ans, key);
            }
        }
        return (int) ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] edges = {1,0,0,0,0,7,7,5};
        HighestEdgeScore score = new HighestEdgeScore();
        System.out.println(score.edgeScore(edges));
        
        int[] edges2 = {2,0,0,2};
        System.out.println(score.edgeScore(edges2));
    }
}


//Optimal solution
import java.io.*;
import java.util.*;

class HighestEdgeScore {
    public int edgeScore(int[] edges) {
        int n = edges.length, score = 0;
        long val = -1L;
        long[] scoreOfEdges = new long[n];
        for(int i=0; i<edges.length; i++) {
            scoreOfEdges[edges[i]]+=i;
        }
        
        for(int i=n-1; i>=0; i--) {
            if(scoreOfEdges[i] >= val) {
                val = scoreOfEdges[i];
                score = i;
            }
        }
        
        return score;
    }
}

class Main {
    public static void main(String[] args) {
        int[] edges = {1,0,0,0,0,7,7,5};
        HighestEdgeScore score = new HighestEdgeScore();
        System.out.println(score.edgeScore(edges));
        
        int[] edges2 = {2,0,0,2};
        System.out.println(score.edgeScore(edges2));
    }
}