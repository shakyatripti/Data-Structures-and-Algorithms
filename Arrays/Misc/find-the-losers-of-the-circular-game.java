//Problem: https://leetcode.com/problems/find-the-losers-of-the-circular-game/description/




import java.io.*;
import java.util.*;


class CircularGame {
    public int[] findLosers(int n, int k) {
        int[] visited = new int[n];
        int curr = 0, i = 1, size = 0, m = 0;
        while(visited[curr]!=-1) {
            visited[curr]=-1;
            int steps = (i * k) % n;
            i++;
            curr = (curr + steps) % n;
        }

        for(int j=0; j<n; j++) {
            if(visited[j]!=-1) {
                size++;
            }
        }

        int[] ans = new int[size];
        for(int j=0; j<n; j++) {
            if(visited[j]!=-1) {
                ans[m] = j+1;
                m++;
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        CircularGame game = new CircularGame();
        int[] ans = game.findLosers(5,2);
        game.display(ans);
        
        int[] ans1 = game.findLosers(4,4);
        game.display(ans1);
    }
}