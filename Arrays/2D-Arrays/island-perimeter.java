//Problem: https://leetcode.com/problems/island-perimeter/description






import java.io.*;
import java.util.*;

class IslandMap {
    public int findPerimeter(int[][] grid) {
        int lands = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    lands += 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        lands--;
                    }

                    if (i < row - 1 && grid[i + 1][j] == 1) {
                        lands--;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        lands--;
                    }

                    if (j < col - 1 && grid[i][j + 1] == 1) {
                        lands--;
                    }
                }
            }
        }

        return lands;
    }
}

class Main {
    public static void main(String[] args) {
        IslandMap map = new IslandMap();

        int[][] grid1 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(map.findPerimeter(grid1));

        int[][] grid2 = {{1}};
        System.out.println(map.findPerimeter(grid2));

        int[][] grid3 = {{1, 0}};
        System.out.println(map.findPerimeter(grid3));
    }
}
