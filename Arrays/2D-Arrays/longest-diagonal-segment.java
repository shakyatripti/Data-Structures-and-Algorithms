/*Problem: (Asked in Visa coding test) Given a matrix of integers, with each element containing either 0, 1 or 2, your task is to find 
    the longest diagonal segment which matches the following pattern: 1, 2, 0, 2, 0, 0 ... (where the first element
    is 1 and then 2 and 0 are repeating infinitely), and finishes at a matrix border. Return the length of this
    diagonal segment. The diagonal segement:
    
    1. May start at any matrix element
    2. May go toward any possible diagonal direction
    3. Must end at an element in the first or last row or column.
*/




import java.io.*;
import java.util.*;

class DiagonalSegment {
    public int longestDiagonal(int[][] matrix) {
        int maxLen=0, n=matrix.length, m=matrix[0].length;
        int[] dx = {-1,1,1,-1};
        int[] dy = {1,-1,1,-1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j]==1) {
                    for(int k=0; k<4; k++) {
                        int len = getPatternLength(matrix, i, j, dx[k], dy[k]);
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }
        }
        return maxLen;
    }
    
    public int getPatternLength(int[][] matrix, int row, int col, int dx, int dy) {
        int n = matrix.length, m = matrix[0].length, len = 0, index = 0;
        int[] pattern = {1,2,0};
        while(row<n && row>=0 && col<m && col>=0) {
            if(matrix[row][col]!=pattern[index]) {
                break;
            }
            len++;
            index = (index==0) ? 1 : (3 - index);
            row+=dx;
            col+=dy;
        }
        
        if(row < 0 || row >= n || col < 0 || col >= m) {
            return len;
        }
        
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        DiagonalSegment segment = new DiagonalSegment();
        int[][] matrix = {
            {0, 0, 1, 2},
            {0, 2, 2, 2},
            {2, 1, 0, 1}
        };
        System.out.println(segment.longestDiagonal(matrix));
        
        int[][] matrix1 = {
            {2, 1, 2, 2, 0},
            {0, 2, 0, 2, 2},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 2, 2},
            {2, 2, 0, 2, 1},
            {0, 2, 0, 0, 2}
        };
        System.out.println(segment.longestDiagonal(matrix1));
        
        int[][] matrix2 = {
            {1, 2, 0, 2},
            {2, 1, 2, 0},
            {0, 2, 1, 2},
            {2, 0, 2, 1}
        };
        System.out.println(segment.longestDiagonal(matrix2));
    }
}
