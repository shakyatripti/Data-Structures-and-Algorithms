//Problem: https://leetcode.com/problems/path-existence-queries-in-a-graph-i/description/



/*Problem Statement: We are given nums array and maxDiff. There exist a path between nums[i] & nums[i+1] if absolute difference
    between them is <= maxDiff. We need to return boolean array answer, where answer[i] is true if there exists a path between ui and vi in the ith query 
    and false otherwise.
    
    Imagine you have people standing in a straight line. Each person is holding a number on a card (that’s the nums[i]). Now the rule is:
    "You can only shake hands with your immediate neighbor if the difference between your numbers is small enough (≤ maxDiff)." If two people can shake hands, 
    we say they are "connected". If they cannot, there’s a gap between them. Now think: If person A can shake hands with person B, and B can shake hands with C,
    then A can indirectly shake hands with C too (through B)! They form a "group of friends" — this is one connected component. When there’s a gap 
    (because the number difference is too big), you break the group, and start a new group.

    Just use the same concept to find connected components within nums and return true if ui & vi belongs to same component, otherwise false.
*/



import java.io.*;
import java.util.*;

class PathExistenceQueries {
    public boolean[] pathExistence(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        component[0] = 0;
        boolean[] result = new boolean[queries.length];
        for(int i=1; i<nums.length; i++) {
            if(Math.abs(nums[i]-nums[i-1]) <= maxDiff) {
                component[i]=component[i-1];
            } else {
                component[i]=component[i-1] + 1;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if(component[u]==component[v]) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }
        return result;
    }
    
    public void display(boolean[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        PathExistenceQueries graph = new PathExistenceQueries();
        int[] nums = {1,3};
        int[][] queries = {{0,0},{0,1}};
        boolean[] ans = graph.pathExistence(2, nums, 1, queries);
        graph.display(ans);
        
        int[] nums1 = {2,5,6,8};
        int[][] queries1 = {{0,1},{0,2},{1,3},{2,3}};
        boolean[] ans2 = graph.pathExistence(4, nums1, 2, queries1);
        graph.display(ans2);
        
        int[] nums2 = {52719,87657};
        int[][] queries2 = {{0,0}};
        boolean[] ans3 = graph.pathExistence(2, nums2, 52, queries2);
        graph.display(ans3);
    }
}