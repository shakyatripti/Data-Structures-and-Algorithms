//Problem: https://leetcode.com/problems/stone-removal-game/description/





import java.io.*;
import java.util.*;


class StoneRemoval {
    public boolean canAliceWin(int n) {
        int turn=10, flag=0;
        while(n >= turn) {
            if(flag==0) {
                n = n-turn;
                turn--;
                flag=1;
            } else if(flag==1) {
                n = n-turn;
                turn--;
                flag=0;
            }
        }
        if(flag==1) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        StoneRemoval game = new StoneRemoval();
        System.out.println(game.canAliceWin(12));
        System.out.println(game.canAliceWin(1));
    }
}