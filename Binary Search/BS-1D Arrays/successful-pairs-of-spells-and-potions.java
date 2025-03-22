//Problem: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/


//1st solution: Best Complexity using BS
import java.io.*;
import java.util.*;

class SpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++) {
            ans[i] = index((long) spells[i], potions, success);
        }
        return ans;
    }
    
    public int index(long spells, int[] potions, long success) {
        if(spells*potions[0] >= success) {
            return potions.length;
        }
        if(spells*potions[potions.length-1] < success) {
            return 0;
        }
        int l=0, r=potions.length-1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(potions[mid]*spells < success) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return potions.length-r;
    }
    
    public void display(int[] ans) {
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        int[] potions = {1,2,3,4,5};
        int[] spells = {5,1,3};
        SpellsAndPotions sp = new SpellsAndPotions();
        int[] ans = sp.successfulPairs(spells,potions,7);
        sp.display(ans);
        
        int[] potions2 = {1,2,3,4,5,6,7};
        int[] spells2 = {1,2,3,4,5,6,7};
        int[] ans2 = sp.successfulPairs(spells2, potions2, 25);
        sp.display(ans2);
    }
}