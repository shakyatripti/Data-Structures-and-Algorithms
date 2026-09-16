//Problem: https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/




import java.io.*;
import java.util.*;


class CircularGame {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1, val = 0;
        for(int i=1; i<=n; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
            if(count==k) {
                q.poll();
                count=0;
            } else {
                val = q.poll();
                q.add(val);
            }
            count++;
        }
        return q.poll();
    }
}

class Main {
    public static void main(String[] args) {
        CircularGame game = new CircularGame();
        System.out.println(game.findTheWinner(5,2));
        System.out.println(game.findTheWinner(6,5));
    }
}