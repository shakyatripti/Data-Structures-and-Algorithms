//Problem: https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/




import java.io.*;
import java.util.*;

class TakeGiftsFromRichestPile {
    public long pickGifts(int[] gifts, int k) {
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int i=0; i<gifts.length; i++) {
            pq.add(gifts[i]);
        }
        while(k!=0) {
            int val = (int) Math.sqrt(pq.poll());
            pq.add(val);
            k--;
        }
        while(!pq.isEmpty()) {
            total+=pq.poll();
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        TakeGiftsFromRichestPile arr = new TakeGiftsFromRichestPile();
        int[] gifts = {25,64,9,4,100};
        System.out.println(arr.pickGifts(gifts, 4));
        
        int[] gifts1 = {1,1,1,1};
        System.out.println(arr.pickGifts(gifts1, 4));
    }
}