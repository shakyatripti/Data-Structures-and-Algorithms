// Problem: https://leetcode.com/problems/course-schedule-ii/description/

import java.util.*;
import java.io.*;

class CourseSchedule {
    public int[] findOrder(int n, int[][] prerequisites) {
         int count = 0;
         int [] ans = new int[n];
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
         for(int i=0; i<n; i++) {
             if(indegree[i]==0) {
                 q.add(i);
             }
         }
         while(!q.isEmpty()) {
             int t = q.poll();
             ans[count] = t;
             count++;
             for(int i=0; i<adj.get(t).size(); i++) {
                 int k = adj.get(t).get(i);
                 indegree[k]--;
                 if(indegree[k]==0) {
                     q.add(k);
                 }
             }
         }
         return count==n ? ans : new int[0];
    }
}

class Main {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
            {1,4},{2,4},{3,1},{3,2}
        };
        int[][] prerequisites2 = new int[][]{
            {1,0},{0,1}
        };
        CourseSchedule courses = new CourseSchedule();
        int[] ans1 = courses.findOrder(5, prerequisites);
        for(int element: ans1) {
            System.out.print(element + " ");
        }
        System.out.print("\n");
        int[] ans2 = courses.findOrder(2, prerequisites);
        System.out.println(ans2.length);
    }
}