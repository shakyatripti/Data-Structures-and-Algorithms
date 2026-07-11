//Problem: https://leetcode.com/problems/last-stone-weight/description/





import java.io.*;
import java.util.*;



class StoneGame {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }

        while(!pq.isEmpty() && pq.size()!=1) {
            int first = pq.poll();
            int second = 0;
            if(!pq.isEmpty()) {
                second = pq.poll();
            }
            int diff = first - second;
            if(diff!=0) {
                pq.add(diff);
            }
        }
        return !pq.isEmpty() ? pq.poll() : 0;
    }
}

class Main {
    public static void main(String[] args) {
        StoneGame game = new StoneGame();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(game.lastStoneWeight(stones));
        
        int[] stones1 = {1};
        System.out.println(game.lastStoneWeight(stones1));
        
        int[] stones2 = {1,3};
        System.out.println(game.lastStoneWeight(stones2));
        
        int[] stones3 = {2,2};
        System.out.println(game.lastStoneWeight(stones3));
    }
}