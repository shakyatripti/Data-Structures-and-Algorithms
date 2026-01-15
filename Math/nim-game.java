//Problem: https://leetcode.com/problems/nim-game/description/


import java.io.*;
import java.util.*;

class NimGame {
    public boolean canWinNim(int n) {
        if(n <= 3) {
            return true;
        }
        if(n%4!=0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        NimGame game = new NimGame();
        System.out.println(game.canWinNim(4));
        System.out.println(game.canWinNim(1));
        System.out.println(game.canWinNim(2));
        System.out.println(game.canWinNim(7));
    }
}