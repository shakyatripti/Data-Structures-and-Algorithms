//Problem: https://leetcode.com/problems/alternating-groups-ii/description/


import java.io.*;
import java.util.*;

class AlternatingGroups {
    public int countAlternatingGroups(int[] colors, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int col: colors) {
            arr.add(col);
        }
        for(int i=0; i<k-1; i++) {
            arr.add(colors[i]);
        }
        int r=1, l=0, groups=0;
        while(r < arr.size()) {
            if(arr.get(r) == arr.get(r-1)) {
                l=r;
            }
            if(r-l+1 == k) {
                l++;
                groups++;
            }
            r++;
        }
        return groups;
    }
}

class Main {
    public static void main(String[] args) {
        int[] colors = {0,1,0,1,0};
        AlternatingGroups groups = new AlternatingGroups();
        System.out.println(groups.countAlternatingGroups(colors, 3));
        int[] colors2 = {0,1,0,0,1,0,1};
        System.out.println(groups.countAlternatingGroups(colors2, 6));
        
    }
}