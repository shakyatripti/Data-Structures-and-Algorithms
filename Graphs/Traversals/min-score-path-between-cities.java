//Problem: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/


//Brute Force Solution
import java.util.*;
import java.io.*;

class MinScorePath {
    public int minimumScore(int n, int[][] roads) {
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,Integer.MAX_VALUE));
        int pathScore = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Pair cities = q.poll();
            int road = cities.road;
            visited[road] = true;
            pathScore = Math.min(pathScore, cities.score);
            for(int i=0; i<adj.get(road).size(); i++) {
                Pair adjCity = adj.get(road).get(i);
                if(!visited[adjCity.road]) {
                    q.add(adjCity);
                }
            }
        }
        return pathScore;
    }
}

class Pair {
    int road;
    int score;
    Pair(int r, int s) {
        road = r;
        score = s;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        MinScorePath path = new MinScorePath();
        System.out.println(path.minimumScore(4, roads));
    }
}


//Optimal solution
import java.util.*;
import java.io.*;

class MinScorePath {
    public int minimumScore(int n, int[][] roads) {
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        int[] pathScore = {Integer.MAX_VALUE};
        findDfs(1,adj,visited,pathScore);
        return pathScore[0];
    }
    
    public void findDfs(int road, ArrayList<ArrayList<Pair>> adj, boolean[] visited, int[] pathScore) {
        visited[road] = true;
        for(int i=0; i<adj.get(road).size(); i++) {
            Pair adjCity = adj.get(road).get(i);
            pathScore[0] = Math.min(pathScore[0], adjCity.score);
            if(!visited[adjCity.road]) {
                findDfs(adjCity.road, adj, visited, pathScore);
            }
        }
    }
}

class Pair {
    int road;
    int score;
    Pair(int r, int s) {
        road = r;
        score = s;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        MinScorePath path = new MinScorePath();
        System.out.println(path.minimumScore(4, roads));
    }
}