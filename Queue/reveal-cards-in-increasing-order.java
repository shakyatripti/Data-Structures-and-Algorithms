//Problem: https://leetcode.com/problems/reveal-cards-in-increasing-order/description




import java.io.*;
import java.util.*;


class RevealCards {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        int[] ans = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<n; i++) {
            dq.add(i);
        }

        Arrays.sort(deck);
        for(int i=0; i<n; i++) {
            int idx = dq.poll();
            ans[idx] = deck[i];
            if(!dq.isEmpty()) {
                dq.add(dq.poll());
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        RevealCards card = new RevealCards();
        int[] deck = {17,13,11,2,3,5,7};
        int[] ans = card.deckRevealedIncreasing(deck);
        card.display(ans);
        
        int[] deck1 = {1,10000};
        int[] ans1 = card.deckRevealedIncreasing(deck1);
        card.display(ans1);
        
        int[] deck2 = {17,13,11,2,3,5,7,20,29};
        int[] ans2 = card.deckRevealedIncreasing(deck2);
        card.display(ans2);
        
        int[] deck3 = {1,2,3,4};
        int[] ans3 = card.deckRevealedIncreasing(deck3);
        card.display(ans3);
        
        int[] deck4 = {17,13,11,2,3,5,7,20,23,29};
        int[] ans4 = card.deckRevealedIncreasing(deck4);
        card.display(ans4);
        
        int[] deck5 = {1,2,3,4,5,6,7,8};
        int[] ans5 = card.deckRevealedIncreasing(deck5);
        card.display(ans5);
        
    }
}