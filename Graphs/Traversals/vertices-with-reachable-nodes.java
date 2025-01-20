//Problem: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/?envType=problem-list-v2&envId=graph

import java.util.*;
import java.io.*;

class FindReachableNodes {
    public List<Integer> minimumVertices(int n, List<List<Integer>> edges) {
        List<Integer> vertices = new ArrayList<Integer>();
        boolean[] visited = new boolean[n];
        for(int i=0; i<edges.size(); i++) {
            int k = edges.get(i).get(1);
            if(!visited[k]) {
              visited[k] = true;
            }
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                vertices.add(i);
            }
        }
        return vertices;
    }
}

class Main {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges.add(new ArrayList<>(Arrays.asList(4, 2)));
        FindReachableNodes graph = new FindReachableNodes();
        List<Integer> arr = graph.minimumVertices(6, edges);
        for(int element: arr) {
            System.out.print(element + " ");
        }
    }
}