//Problem: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/





import java.io.*;
import java.util.*;


class CountUnguardedCells {
    public int countCells(int m, int n, int[][] guards, int[][] walls) {
        int count = 0;
        int[][] mat = new int[m][n];
        for(int i=0; i<walls.length; i++) {
            mat[walls[i][0]][walls[i][1]] = 1;
        }

        for(int i=0; i<guards.length; i++) {
            mat[guards[i][0]][guards[i][1]] = 2;
        }

        for(int i=0; i<guards.length; i++) {
            markGuarded(mat, guards[i][0], guards[i][1], m, n);
            
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==0) {
                    count++;
                }
            }
        }
        return count;
    }

    public void markGuarded(int[][] mat, int row, int col, int m, int n) {
        for(int i=row-1; i>=0; i--) {
            if(mat[i][col]==1 || mat[i][col]==2) {
                break;
            } else {
                mat[i][col] = -1;
            }
        }

        for(int i=row+1; i<m; i++) {
            if(mat[i][col]==1 || mat[i][col]==2) {
                break;
            } else {
                mat[i][col] = -1;
            }
        }

        for(int i=col-1; i>=0; i--) {
            if(mat[row][i]==1 || mat[row][i]==2) {
                break;
            } else {
                mat[row][i] = -1;
            }
        }

        for(int i=col+1; i<n; i++) {
            if(mat[row][i]==1 || mat[row][i]==2) {
                break;
            } else {
                mat[row][i] = -1;
            }
        }
    }
}


class Main {
    public static void main(String[] args) {
        CountUnguardedCells mat = new CountUnguardedCells();
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};
        System.out.println(mat.countCells(4,6,guards,walls));
        
        int[][] guards1 = {{1,1}};
        int[][] walls1 = {{0,1},{1,0},{2,1},{1,2}};
        System.out.println(mat.countCells(3,3,guards1,walls1));
    }
}
