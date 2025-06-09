//Problem: https://leetcode.com/problems/merge-similar-items/description/




import java.io.*;
import java.util.*;

class MergeSimilarItems {
    public List<List<Integer>> merge(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] freq = new int[1001];
        for(int i=0; i<items1.length; i++) {
            freq[items1[i][0]]+=items1[i][1];
        }
        for(int i=0; i<items2.length; i++) {
            freq[items2[i][0]]+=items2[i][1];
        }
        for(int i=0; i<1001; i++) {
            if(freq[i]!=0) {
               ArrayList<Integer> occurrence = new ArrayList<>();
               occurrence.add(i);
               occurrence.add(freq[i]);
               ans.add(occurrence);
            }
        }
        return ans;
    }
    
    public static void display(List<List<Integer>> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) +  " ");
            }
            System.out.print(" ");
        }
        System.out.print("\n");
    }
}


class Main {
    public static void main(String[] args) {
        MergeSimilarItems items = new MergeSimilarItems();
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};
        List<List<Integer>> ans = items.merge(items1, items2);
        items.display(ans);
        
        int[][] items3 = {{1, 3}, {2, 2}};
        int[][] items4 = {{7, 1}, {2, 2}, {1, 4}};
        List<List<Integer>> ans1 = items.merge(items3, items4);
        items.display(ans1);
        
        int[][] items5 = {{1, 1}, {3, 2}, {2, 3}};
        int[][] items6 = {{2, 1}, {3, 2}, {1, 3}};
        List<List<Integer>> ans2 = items.merge(items5, items6);
        items.display(ans2);
    }
}