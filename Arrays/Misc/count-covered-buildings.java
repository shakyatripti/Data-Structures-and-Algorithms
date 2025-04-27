//Problem: https://leetcode.com/problems/count-covered-buildings/description/


/*Problem Statement: We need to count such buildings which are 4-directionally covered by other buildings. The 4-directions can be 
    explained as left(same row, lower column), right(same row, higher column), top(same column, lower row) & bottom(same column, higher row).

    Suppose (x,y) be the position. For every row, we will calculate minRow and maxRow. MinRow is the minimum column index in that row and maxRow is the 
    maximum column index in that row. If minRow[x] < y, this means there is a building on left and if maxRow[x] > y, this means there is a building on right.

    Similarly we will calculate minCol and maxCol. MinCol is the minimum row index in that column and maxCol is the maximum row index in that column.
    If minCol[y] < x, this mean there is a building on top and if maxCol[y] > x, this means there is a building below. If all 4 conditions satisfies, the 
    building is said to be covered.
*/


import java.util.*;
import java.io.*;

class CoveredBuildings {
    public int count(int n, int[][] buildings) {
        int result=0;
        int[] maxRow = new int[n+1], minRow = new int[n+1];
        int[] maxCol = new int[n+1], minCol = new int[n+1];
        Arrays.fill(minRow, n+1);
        Arrays.fill(minCol, n+1);
        
        for(int i=0; i<buildings.length; i++) {
            int x = buildings[i][0], y = buildings[i][1];
            minRow[x] = Math.min(minRow[x], y);
            maxRow[x] = Math.max(maxRow[x], y);
            minCol[y] = Math.min(minCol[y], x);
            maxCol[y] = Math.max(maxCol[y], x);
        }
        
        for(int i=0; i<buildings.length; i++) {
            int x=buildings[i][0], y=buildings[i][1];
            if(maxRow[x] > y && minRow[x] < y && maxCol[y] > x && minCol[y] < x) {
                result++;
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        CoveredBuildings covered = new CoveredBuildings();
        int[][] buildings = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        System.out.println(covered.count(3, buildings));
        
        int[][] buildings2 = {{2,4},{1,2},{3,1},{1,4},{2,3},{3,3},{2,2},{1,3}};
        System.out.println(covered.count(4, buildings2));
        
        int[][] buildings3 = {{1,1},{1,2},{2,1},{2,2}};
        System.out.println(covered.count(3, buildings3));
    }
}