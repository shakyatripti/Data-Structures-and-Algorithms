//Problem: https://leetcode.com/problems/course-schedule-iv/description/

import java.util.*;
import java.io.*;

class CourseSchedule {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
         List<Boolean> ans = new ArrayList<Boolean>();
         Queue<Integer> q = new LinkedList<>();
         int[] indegree = new int[n];
         ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
         for(int i=0; i<n; i++) {
             adj.add(new ArrayList<>());
         }
         for(int i=0; i<prerequisites.length; i++) {
             adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
             indegree[prerequisites[i][1]]++;
         }
         Map<Integer, HashSet<Integer>> mp = new HashMap<Integer, HashSet<Integer>>();
         for(int i=0; i<n; i++) {
             mp.put(i, new HashSet<Integer>());
             if(indegree[i]==0) {
                 q.add(i);
             }
         }
         while(!q.isEmpty()) {
             int t = q.poll();
             for(int i=0; i<adj.get(t).size(); i++) {
                 int k = adj.get(t).get(i);
                 mp.get(k).add(t);
                 mp.get(k).addAll(mp.get(t));
                 indegree[k]--;
                 if(indegree[k]==0) {
                     q.add(k);
                 }
             }
         }
         for(int i=0; i<queries.length; i++) {
             boolean reachable = mp.get(queries[i][1]).contains(queries[i][0]);
             ans.add(reachable);
         }
         return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
            {0,1},{1,2},{2,3},{3,4}
        };
        int[][] queries = new int[][] {
            {0,4},{4,0},{1,3},{3,0}
        };
        int[][] prerequisites2 = new int[][]{
            {2,3},{2,1},{0,3},{0,1}
        };
        int[][] queries2 = new int[][]{
            {0,1},{0,3},{2,3},{3,0},{2,0},{0,2}
        };
        CourseSchedule courses = new CourseSchedule();
        List<Boolean> ans1 = courses.checkIfPrerequisite(5, prerequisites,queries);
        for(Boolean element: ans1) {
            System.out.print(element + " ");
        }
        System.out.print("\n");
        List<Boolean> ans2 = courses.checkIfPrerequisite(4, prerequisites2,queries2);
        for(Boolean element: ans2) {
            System.out.print(element + " ");
        }
    }
}