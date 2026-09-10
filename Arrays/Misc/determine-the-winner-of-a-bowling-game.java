//Problem: https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/description/




import java.io.*;
import java.util.*;


class BowlingGame {
    public int isWinner(int[] player1, int[] player2) {
        int score1=totalScore(player1);
        int score2=totalScore(player2);
        if(score1 > score2) {
            return 1;
        }
        if(score1 < score2) {
            return 2;
        }
        return 0;
    }

    public int totalScore(int[] num) {
        int n=num.length, total=0;
        for(int i=0; i<n; i++) {
            if(i > 0 && (num[i-1]==10)) {
                total+=num[i]*2;
            } else if(i > 1 && (num[i-2]==10)) {
                total+=num[i]*2;
            } else {
                total+=num[i];
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();
        int[] player1 = {5,10,3,2};
        int[] player2 = {6,5,7,3};
        System.out.println(game.isWinner(player1, player2));
        
        int[] player3 = {3,5,7,6};
        int[] player4 = {8,10,10,2};
        System.out.println(game.isWinner(player3, player4));
        
        int[] player5 = {2,3};
        int[] player6 = {4,1};
        System.out.println(game.isWinner(player5, player6));
        
        int[] player7 = {1,1,1,10,10,10,10};
        int[] player8 = {10,10,10,10,1,1,1};
        System.out.println(game.isWinner(player7, player8));
        
        int[] player9 = {0,1,8};
        int[] player10 = {3,9,1};
        System.out.println(game.isWinner(player9, player10));
    }
}