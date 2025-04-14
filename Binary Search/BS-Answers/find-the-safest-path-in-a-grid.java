//Problem: https://leetcode.com/problems/find-the-safest-path-in-a-grid/description/


/*Problem Statement: We need to find such path with which we can reach (n-1, n-1) cell with maximum safeness factor.
    Maximum safeness factor = Minimum Manhattan distance from thief. Basically find such path so that all 0's is as far as possible from 
    nearest 1's. For example safenessFactor is 2, it means all the 0's is atleast 2 distance away from nearest 1's. So we need to find such
    maximum safeness factor.
*/



import java.io.*;
import java.util.*;

class SafestPathInGrid {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size(), l=1, r=400, result=0;
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};
        List<List<Integer>> distanceMatrix = safestPath(grid, n, dx, dy);
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(isPathSafe(distanceMatrix, n, mid, dx, dy)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
    
    public boolean isPathSafe(List<List<Integer>> distanceMatrix, int n, int mid, int[] dx, int[] dy) {
        if(distanceMatrix.get(0).get(0) < mid) {
            return false;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                if(row==n-1 && col==n-1) {
                    return true;
                }
                for(int j=0; j<4; j++) {
                    int x = dx[j] + row;
                    int y = dy[j] + col;
                    if(x>=0 && y>=0 && x<n && y<n && !visited[x][y]) {
                        if(distanceMatrix.get(x).get(y) < mid) {
                            continue;
                        }
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return false;
    }
    
    public List<List<Integer>> safestPath(List<List<Integer>> grid, int n, int[] dx, int[] dy) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                visited[i][j] = false;
                if(grid.get(i).get(j)==1) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        int dist = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cell = q.poll();
                grid.get(cell[0]).set(cell[1], dist + 1);
                for(int j=0; j<4; j++) {
                    int x = dx[j] + cell[0];
                    int y = dy[j] + cell[1];
                    if(x>=0 && y>=0 && x<n && y<n && !visited[x][y]) {
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            dist++;
        }
        return grid;
    }
}

class Main {
    public static void main(String[] args) {
        SafestPathInGrid path = new SafestPathInGrid();
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,1)));
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(1,0,0,0)));
        System.out.println(path.maximumSafenessFactor(grid));
        
        List<List<Integer>> grid2 = new ArrayList<>();
        grid2.add(new ArrayList<>(Arrays.asList(1,0,0)));
        grid2.add(new ArrayList<>(Arrays.asList(0,0,0)));
        grid2.add(new ArrayList<>(Arrays.asList(0,0,1)));
        System.out.println(path.maximumSafenessFactor(grid2));
        
        List<List<Integer>> grid3 = new ArrayList<>();
        grid3.add(new ArrayList<>(Arrays.asList(0,0,1)));
        grid3.add(new ArrayList<>(Arrays.asList(0,0,0)));
        grid3.add(new ArrayList<>(Arrays.asList(0,0,0)));
        System.out.println(path.maximumSafenessFactor(grid3));
    }
}