//Problem: https://leetcode.com/problems/stone-game/description/






import java.io.*;
import java.util.*;

class StoneGame {
    public boolean aliceWon(int[] piles) {
        int alice=0, bob=0, flag=0, l=0, r=piles.length-1;
        while(l<r && r < piles.length && l < piles.length)  {
            if(flag==0 && piles[l] >= piles[r]) {
                alice+=piles[l];
                l++;
                flag=1;
            } else if(flag==0 && piles[r] > piles[l]) {
                alice+=piles[r];
                r--;
                flag=1;
            } else if(flag==1 && piles[l] >= piles[r]) {
                bob+=piles[r];
                r--;
                flag=0;
            } else {
                bob+=piles[l];
                l++;
                flag=0;
            }
        }
        if(alice > bob) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        StoneGame game = new StoneGame();
        int[] piles = {5,3,4,5};
        System.out.println(game.aliceWon(piles));
        
        int[] piles1 = {3,7,2,3};
        System.out.println(game.aliceWon(piles1));
    }
}