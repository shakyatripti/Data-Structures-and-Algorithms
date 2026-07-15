//Problem: https://leetcode.com/problems/count-of-matches-in-tournament/description/



import java.io.*;
import java.util.*;

class Tournament {
    public int numberOfMatches(int n) {
        int team,match=0;
        while(n!=1)
        {
            if(n%2!=0)
            {
                match+=((n-1)/2)+1;
                n=(n-1)/2;
            }
            else
            {
                match+=n/2;
                n=n/2;
            }
        }
        return match;
    }
}

class Main {
    public static void main(String[] args) {
        Tournament game = new Tournament();
        System.out.println(game.numberOfMatches(7));
        System.out.println(game.numberOfMatches(14));
    }
}