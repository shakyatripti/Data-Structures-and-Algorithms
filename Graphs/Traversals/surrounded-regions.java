//Problem: https://leetcode.com/problems/surrounded-regions/description/

//1st solution: Using BFS
import java.util.*;
import java.io.*;

class SurroundedRegions {
    public void surround(char[][]board) {
        int n=board.length, m=board[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1) && !visited[i][j] && board[i][j]=='O') {
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] t = q.poll();
                for(int j=0; j<4; j++) {
                    int x = t[0] + dx[j];
                    int y = t[1] + dy[j];
                    if(x>=0 && y>=0 && x<n && y<m && board[x][y]=='O' && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'X','X','X','X'},
            {'O','X','O','X'},
            {'X','O','O','X'},
            {'X','X','X','X'}
        };
        SurroundedRegions regions = new SurroundedRegions();
        regions.surround(board);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

//2nd Solution: Using DFS
import java.util.*;
import java.io.*;

class SurroundedRegions {
    public void surround(char[][]board) {
        int n=board.length, m=board[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1) && !visited[i][j] && board[i][j]=='O') {
                    visited[i][j] = true;
                    findDfs(i,j,board,visited);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }
    
    public void findDfs(int sr, int sc, char[][]board, boolean[][] visited) {
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int a = board.length, b=board[0].length;
        for(int j=0; j<4; j++) {
            int x = sr + dx[j];
            int y = sc + dy[j];
            if(x>=0 && y>=0 && x<a && y<b && board[x][y]=='O' && !visited[x][y]) {
                visited[x][y] = true;
                findDfs(x,y,board,visited);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'X','X','X','O'},
            {'O','X','O','X'},
            {'X','O','O','X'},
            {'X','X','X','O'}
        };
        SurroundedRegions regions = new SurroundedRegions();
        regions.surround(board);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
