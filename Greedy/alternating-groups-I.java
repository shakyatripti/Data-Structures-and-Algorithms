//Problem: https://leetcode.com/problems/alternating-groups-i/description/




import java.io.*;
import java.util.*;

class AlternatingGroups {
    public int count(int[] colors) {
        int n=colors.length, groups=0;
        for(int i=0; i<n; i++) {
            int prev = (n + i - 1) % n;
            int next = (i + 1) % n;
            if(colors[prev]!=colors[i] && colors[next]!=colors[i]) {
                groups++;
            }
        }
        return groups;
    }
}

class Main {
    public static void main(String[] args) {
        AlternatingGroups groups = new AlternatingGroups();
        int[] colors = {1,1,1};
        System.out.println(groups.count(colors));
        
        int[] colors1 = {0,1,0,0,1};
        System.out.println(groups.count(colors1));
    }
}