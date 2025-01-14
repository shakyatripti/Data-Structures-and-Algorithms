//Problem: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1


//Better Solution
import java.util.*;
import java.io.*;

class DFSInGraph {
    public List<Integer> dfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> s = new Stack<>();
        List<Integer> traversal = new ArrayList<Integer>();
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, Boolean.FALSE);
        s.push(0);
        while(!s.isEmpty()) {
            int topVertex = s.pop();
            if(visited[topVertex]==false) {
                visited[topVertex]=true;
                traversal.add(topVertex);
            }
            for(int i=adj.get(topVertex).size()-1; i>=0; i--) {
                int val = adj.get(topVertex).get(i);
                if(visited[val]==false) {
                    s.push(val);
                }
            }
        }
        return traversal;
    }
    
    public void adjacencyList(int v, int u, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Main  {
    public static void main(String[] args) {
        int v = 10, edge =13;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<edge; i++) {
            adj.add(new ArrayList<>());
        }
        DFSInGraph graph = new DFSInGraph();
        //Edge 0---1
        graph.adjacencyList(0,1,adj);
        //Edge 0---2
        graph.adjacencyList(0,2,adj);
        //Edge 0---4
        graph.adjacencyList(0,4,adj);
        //Edge 0---8
        graph.adjacencyList(0,8,adj);
        //Edge 1---5
        graph.adjacencyList(1,5,adj);
        //Edge 1---6
        graph.adjacencyList(1,6,adj);
        //Edge 1---9
        graph.adjacencyList(1,9,adj);
        //Edge 2---4
        graph.adjacencyList(2,4,adj);
        //Edge 3---7
        graph.adjacencyList(3,7,adj);
        //Edge 3---8
        graph.adjacencyList(3,8,adj);
        //Edge 5---8
        graph.adjacencyList(5,8,adj);
        //Edge 6---7
        graph.adjacencyList(6,7,adj);
        //Edge 6---9
        graph.adjacencyList(6,9,adj);
        List<Integer> traversal = graph.dfsTraversal(v,adj);
        for(int val: traversal) {
            System.out.print(val + " ");
        }
        
    }
}

//Optimal Solution
import java.util.*;
import java.io.*;

class DFSInGraph {
    public List<Integer> dfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> traversal = new ArrayList<Integer>();
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, Boolean.FALSE);
        findDfs(adj,traversal,visited,0);
        return traversal;
    }
    
    public void findDfs(ArrayList<ArrayList<Integer>> adj, List<Integer> traversal, boolean[]visited, int node) {
        traversal.add(node);
        visited[node]=true;
        for(int val: adj.get(node)) {
            if(visited[val] == false) {
                findDfs(adj,traversal,visited,val);
            }
        }
        
    }
    
    public void adjacencyList(int v, int u, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Main  {
    public static void main(String[] args) {
        int v = 10, edge =13;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<edge; i++) {
            adj.add(new ArrayList<>());
        }
        DFSInGraph graph = new DFSInGraph();
        //Edge 0---1
        graph.adjacencyList(0,1,adj);
        //Edge 0---2
        graph.adjacencyList(0,2,adj);
        //Edge 0---4
        graph.adjacencyList(0,4,adj);
        //Edge 0---8
        graph.adjacencyList(0,8,adj);
        //Edge 1---5
        graph.adjacencyList(1,5,adj);
        //Edge 1---6
        graph.adjacencyList(1,6,adj);
        //Edge 1---9
        graph.adjacencyList(1,9,adj);
        //Edge 2---4
        graph.adjacencyList(2,4,adj);
        //Edge 3---7
        graph.adjacencyList(3,7,adj);
        //Edge 3---8
        graph.adjacencyList(3,8,adj);
        //Edge 5---8
        graph.adjacencyList(5,8,adj);
        //Edge 6---7
        graph.adjacencyList(6,7,adj);
        //Edge 6---9
        graph.adjacencyList(6,9,adj);
        List<Integer> traversal = graph.dfsTraversal(v,adj);
        for(int val: traversal) {
            System.out.print(val + " ");
        }
        
    }
}