//Problem: https://leetcode.com/problems/last-visited-cell-in-a-directional-grid/description/





import java.io.*;
import java.util.*;


class DirectionalGrid {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length, n = grid[0].length, r = 0, c = 0, p = 0, q = 0;
        boolean[][] visited = new boolean[m][n];
        while(isValidMove(m, n, r, c, visited)) {
            p = r;
            q = c;
            visited[r][c] = true;
            if(grid[r][c]=='R') {
                c++;
            } else if(grid[r][c]=='L') {
                c--;
            } else if(grid[r][c]=='U') {
                r--;
            } else {
                r++;
            }
        }
        return new int[]{p,q};
    }

    public boolean isValidMove(int m, int n, int r, int c, boolean[][] visited) {
        if(r>=m || c>=n || r<0 || c<0 || visited[r][c]==true) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        DirectionalGrid mat = new DirectionalGrid();
        char[][] grid = {{'R','D'},{'U','L'}};
        int[] ans = mat.lastVisitedCell(grid);
        System.out.println(ans[0] + " " + ans[1]);
        
        char[][] grid1 = {{'R','R','R'}};
        int[] ans1 = mat.lastVisitedCell(grid1);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        char[][] grid2 = {{'U'}};
        int[] ans2 = mat.lastVisitedCell(grid2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}