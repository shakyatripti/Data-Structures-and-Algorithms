//Problem: https://leetcode.com/problems/flood-fill/description/

//1st solution: Better solution
import java.util.*;
import java.io.*;

class FloodFill {
    public int[][] floodFill(int[][]image, int color, int sc, int sr) {
        Stack<int[]> st = new Stack<>();
        int orgColor = image[sr][sc];
        if(orgColor!=color) {
            st.push(new int[]{sr,sc});
            image[sr][sc] = color;
        }
        return findDfs(image, color, orgColor, st);
    }
    
    public int[][] findDfs(int[][] image, int color, int orgColor, Stack<int[]> st) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int r=image.length, c=image[0].length;
        while(!st.isEmpty()) {
            int[] node = st.pop();
            for(int i=0; i<4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                if(x>=0 && x<r && y>=0 && y<c && image[x][y] == orgColor) {
                    st.push(new int[]{x,y});
                    image[x][y] = color;
                }
            }
        }
        return image;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] image = new int[3][3];
        int color = 2, sr=1,sc=1;
        image[0][0] = 1;
        image[0][1] = 1;
        image[0][2] = 2;
        image[1][0] = 0;
        image[1][1] = 1;
        image[1][2] = 0;
        image[2][0] = 1;
        image[2][1] = 0;
        image[2][2] = 1;
        FloodFill f = new FloodFill();
        int[][] ans = f.floodFill(image,color,sr,sc);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println("\n");
        }
        
    }
}

//2nd solution: Optimal Solution
import java.util.*;
import java.io.*;

class FloodFill {
    public int[][] floodFill(int[][]image, int color, int sr, int sc) {
        int orgColor = image[sr][sc];
        if(orgColor!=color) {
            findDfs(image, color, sr, sc, orgColor);
        }
        return image;
    }
    
    public void findDfs(int[][] image, int color, int sr, int sc, int orgColor) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int r=image.length, c=image[0].length;
        image[sr][sc] = color;
        for(int i=0; i<4; i++) {
            int x = sr + dx[i];
            int y = sc + dy[i];
            if(x>=0 && x<r && y>=0 && y<c && image[x][y] == orgColor && image[x][y]!=color) {
                findDfs(image,color,x,y,orgColor);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] image = new int[][] {
            {1,2,1},
            {1,1,0},
            {0,0,0}
        };
        int color = 2, sr=1,sc=1;
        FloodFill f = new FloodFill();
        int[][] ans = f.floodFill(image,color,sr,sc);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println("\n");
        }
        
    }
}