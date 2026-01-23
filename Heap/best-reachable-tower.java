//Problem: https://leetcode.com/problems/best-reachable-tower/description/




import java.io.*;
import java.util.*;

class ReachableTower {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] res = new int[2];
        res[0]=-1; res[1]=-1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> {
            if(x[2]==y[2]) {
                if(x[0]!=y[0]) {
                    return Integer.compare(x[0], y[0]);
                }
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(y[2], x[2]);
        });
        for(int i=0; i<towers.length; i++) {
            int x = Math.abs(towers[i][0] - center[0]);
            int y = Math.abs(towers[i][1] - center[1]);
            if(x+y <= radius) {
                pq.add(towers[i]);
            }
        }

        if(!pq.isEmpty()) {
            int[] ans = pq.poll();
            res[0] = ans[0];
            res[1] = ans[1];
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        ReachableTower arr = new ReachableTower();
        int[][] towers = {{1,2,5},{2,1,7},{3,1,9}};
        int[] center = {1,1};
        int[] ans = arr.bestTower(towers, center, 2);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[][] towers1 = {{1,3,4},{2,2,4},{4,4,7}};
        int[] center1 = {0,0};
        int[] ans1 = arr.bestTower(towers1, center1, 5);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[][] towers2 = {{5,6,8},{0,3,5}};
        int[] center2 = {1,2};
        int[] ans2 = arr.bestTower(towers2, center2, 1);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}