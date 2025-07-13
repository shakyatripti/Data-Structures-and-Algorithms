//Problem: https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/
//NOTE: This is same as Assign Cookies problem (https://leetcode.com/problems/assign-cookies/description/)




import java.io.*;
import java.util.*;

class MaxMatching {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l=0, r=0, count=0;
        while(l < players.length && r < trainers.length) {
            if(players[l] <= trainers[r]) {
                l++;
                count++;
            }
            r++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MaxMatching match = new MaxMatching();
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};
        System.out.println(match.matchPlayersAndTrainers(players, trainers));
        
        int[] players1 = {1,1,1};
        int[] trainers1 = {10};
        System.out.println(match.matchPlayersAndTrainers(players1, trainers1));
    }
}