//Problem: https://leetcode.com/problems/best-poker-hand/description/




import java.io.*;
import java.util.*;

class PokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        String ans = "High Card";
        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Integer, Integer> mp1 = new HashMap<>();
        for(int i=0; i<suits.length; i++) {
            mp.put(suits[i], mp.getOrDefault(suits[i], 0) + 1);
        }

        for(int i=0; i<ranks.length; i++) {
            mp1.put(ranks[i], mp1.getOrDefault(ranks[i], 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: mp.entrySet()) {
            int value = entry.getValue();
            if(value==5) {
                return "Flush";
            }
        }

        for(Map.Entry<Integer, Integer> entry: mp1.entrySet()) {
            int value = entry.getValue();
            if(value>=3) {
                return "Three of a Kind";
            }
            if(value==2) {
                ans = "Pair";
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        PokerHand poker = new PokerHand();
        int[] ranks = {13,2,3,1,9};
        char[] suits = {'a','a','a','a','a'};
        System.out.println(poker.bestHand(ranks, suits));
        
        int[] ranks1 = {4,4,2,4,4};
        char[] suits1 = {'d','a','a','b','c'};
        System.out.println(poker.bestHand(ranks1, suits1));
        
        int[] ranks2 = {10,10,2,12,9};
        char[] suits2 = {'a','b','c','a','d'};
        System.out.println(poker.bestHand(ranks2, suits2));
        
    }
}