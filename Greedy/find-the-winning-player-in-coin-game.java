//Problem: https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/




import java.io.*;
import java.util.*;

class CoinGame {
    public String winningPlayer(int x, int y) {
        int turns = 0;
        while(x > 0 && y > 3) {
            x--;
            y-=4;
            turns++;
        }
        if(turns%2==0) {
            return "Bob";
        }
        return "Alice";
    }
}

class Main {
    public static void main(String[] args) {
        CoinGame game = new CoinGame();
        System.out.println(game.winningPlayer(2,7));
        System.out.println(game.winningPlayer(4,11));
    }
}