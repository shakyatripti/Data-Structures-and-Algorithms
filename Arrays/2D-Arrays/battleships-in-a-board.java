//Problem: https://leetcode.com/problems/battleships-in-a-board/description/




import java.io.*;
import java.util.*;


class BattleshipBoard {
    public int countBattleships(char[][] board) {
        int m=board.length, n=board[0].length, count=0;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]!=-1 && board[i][j]=='X') {
                    traverseBoard(board, i, j, m, n, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void traverseBoard(char[][] board, int i, int j, int m, int n, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            visited[pos[0]][pos[1]]=-1;
            for(int k=0; k<4; k++) {
                int x = dx[k] + pos[0];
                int y = dy[k] + pos[1];
                if(x>=0 && x<m && y>=0 && y<n && visited[x][y]!=-1 && board[x][y]=='X') {
                    q.add(new int[]{x,y});
                }
            }
        }
    }
}


class Main {
    public static void main(String[] args) {
        BattleshipBoard mat = new BattleshipBoard();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(mat.countBattleships(board));
        
        char[][] board1 = {{'.'}};
        System.out.println(mat.countBattleships(board1));
    }
}