//Problem: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

import java.util.*;
import java.io.*;

class NearestExitInMaze {
    public int findExit(char[][] maze, int[] entrance) {
        int r=maze.length, c=maze[0].length, count=1;
        boolean[][] visited = new boolean[r][c];
        for(int i=0; i<r; i++) {
            Arrays.fill(visited[i], false);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        visited[entrance[0]][entrance[1]] = true;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] path = q.poll();
                for(int j=0; j<4; j++) {
                    int x = dx[j] + path[0];
                    int y = dy[j] + path[1];
                    if(x>=0 && y>=0 && x<r && y<c && !visited[x][y] && maze[x][y]=='.') {
                        if((x==0 || y==0 || x==r-1 || y==c-1) && maze[x][y]=='.') {
                            return count;
                        }
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'},{'+', '+', '+', '.'}};
        int[] entrance = {1,2};
        char[][] maze2 = { {'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'} };
        int[] entrance2 = {1,0};
        char[][] maze3 = { {'.', '+'} };
        int[] entrance3 = {0,0};
        NearestExitInMaze exit = new NearestExitInMaze();
        System.out.println(exit.findExit(maze, entrance));
        System.out.println(exit.findExit(maze2, entrance2));
        System.out.println(exit.findExit(maze3, entrance3));
    }
}
