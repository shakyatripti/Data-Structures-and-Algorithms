//Problem: https://leetcode.com/problems/all-paths-from-source-to-target/description/


import java.io.*;
import java.util.*;

class PathsFromSourceToTarget {
    public List<List<Integer>> allPaths(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> subPaths = new ArrayList<Integer>();
        findDfs(0,graph,paths,subPaths);
        return paths;
    }
    
    public void findDfs(int node, int[][] graph, List<List<Integer>> paths, List<Integer> subPaths) {
        subPaths.add(node);
        if(node==graph.length-1) {
            paths.add(new ArrayList<>(subPaths));
            return;
        }
        for(int i=0; i<graph[node].length; i++) {
            findDfs(graph[node][i], graph, paths, subPaths);
            subPaths.remove(subPaths.size()-1);
        }
    }
    
    public void print(List<List<Integer>> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        PathsFromSourceToTarget paths = new PathsFromSourceToTarget();
        List<List<Integer>> ans = paths.allPaths(graph);
        paths.print(ans);
        System.out.println("\n");
        int[][] graph2 = {{4,3,1},{3,2,4},{},{4},{}};
        List<List<Integer>> ans2 = paths.allPaths(graph2);
        paths.print(ans2);
    }
}