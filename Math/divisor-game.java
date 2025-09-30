//Problem: https://leetcode.com/problems/divisor-game/description/



import java.io.*;
import java.util.*;

class DivisorGame {
    public boolean aliceWon(int n) {
        if(n%2==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        DivisorGame game = new DivisorGame();
        System.out.println(game.aliceWon(2));
        System.out.println(game.aliceWon(3));
        System.out.println(game.aliceWon(8));
    }
}