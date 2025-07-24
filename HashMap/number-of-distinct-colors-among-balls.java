//Problem: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/


import java.io.*;
import java.util.*;

class DistinctColorsAmongBalls {
    public int[] countDistinct(int limit, int[][] queries) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> colorsMap = new HashMap<Integer, Integer>();
        int distinct = 0, j=0;
        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int ball = queries[i][0], color = queries[i][1];
            if(mp.containsKey(ball)) {
                int k = mp.get(ball);
                colorsMap.put(k, colorsMap.get(k)-1);
                if(colorsMap.get(k)==0) {
                    distinct--;
                }
            }
            mp.put(ball,color);
            if(colorsMap.containsKey(color)) {
                colorsMap.put(color, colorsMap.get(color) + 1);
            } else {
                colorsMap.put(color, 1);
            }
            if(colorsMap.get(color)==1) {
                distinct++;
            }
            result[j] = distinct;
            j++;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] queries = {{1,4},{2,3},{1,3},{2,4}};
        int[][] queries2 = {{1,4},{2,5},{1,3},{3,4}};
        DistinctColorsAmongBalls balls = new DistinctColorsAmongBalls();
        int[] result = balls.countDistinct(4, queries);
        for(int ele: result) {
            System.out.print(ele +  " ");
        }
        System.out.print("\n");
        int[] result2 = balls.countDistinct(4, queries2);
        for(int ele: result2) {
            System.out.print(ele + " ");
        }
    }
}