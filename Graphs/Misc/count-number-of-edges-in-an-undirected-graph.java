//Problem: https://www.geeksforgeeks.org/problems/count-number-of-edges-in-an-undirected-graph/




import java.io.*;
import java.util.*;

class UndirectedGraph {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int edges = 0;
        for(int i=0; i<adj.size(); i++) {
            edges+=adj.get(i).size();
        }
        return edges/2;
    }
}

class Main {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(3)));
        System.out.println(graph.countEdges(adj));
        
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>();
        adj1.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj1.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        adj1.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        adj1.add(new ArrayList<Integer>(Arrays.asList(2)));
        System.out.println(graph.countEdges(adj1));
    }
}