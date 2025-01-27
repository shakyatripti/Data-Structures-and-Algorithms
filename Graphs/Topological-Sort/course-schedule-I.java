//Problem: https://leetcode.com/problems/course-schedule/

import java.util.*;
import java.io.*;

class CourseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
         int count = 0;
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
             count++;
             for(int i=0; i<adj.get(t).size(); i++) {
                 int k = adj.get(t).get(i);
                 indegree[k]--;
                 if(indegree[k]==0) {
                     q.add(k);
                 }
             }
         }
         return count==n ? true : false;
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
        System.out.println(courses.canFinish(5,prerequisites));
        System.out.println(courses.canFinish(2,prerequisites2));
    }
}