//Problem: https://leetcode.com/problems/sort-the-people/description/



import java.io.*;
import java.util.*;

class SortThePeople {
    public String[] sorting(String[] names, int[] heights) {
        String[] sortedNames = new String[names.length];
        HashMap<Integer, String> peoples = new HashMap<>();
        for(int i=0; i<names.length; i++) {
            peoples.put(heights[i], names[i]);
        }
        int k=0;
        Arrays.sort(heights);
        for(int i=heights.length-1; i>=0; i--) {
            sortedNames[k] = peoples.get(heights[i]);
            k++;
        }
        return sortedNames;
    }
    
    public void display(String[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("\n");
    }
    
}

class Main {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        SortThePeople peoples = new SortThePeople();
        String[] ans = peoples.sorting(names, heights);
        peoples.display(ans);
        
        String[] names1 = {"Alice","Bob","Bob"};
        int[] heights1 = {155,185,150};
        String[] ans1 = peoples.sorting(names1, heights1);
        peoples.display(ans1);
    }
}