//Problem: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/


import java.io.*;
import java.util.*;

class KidsWithCandies {
    public List<Boolean> findKids(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<Boolean>();
        int maxCandy = 0;
        for(int i=0; i<candies.length; i++) {
            maxCandy = Math.max(candies[i], maxCandy);
        }

        for(int i=0; i<candies.length; i++) {
            if(candies[i] + extraCandies >= maxCandy) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
    
    public void display(List<Boolean> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        KidsWithCandies k = new KidsWithCandies();
        int[] candies = {2,3,5,1,3};
        List<Boolean> ans = k.findKids(candies, 3);
        k.display(ans);
        
        int[] candies1 = {4,2,1,1,2};
        List<Boolean> ans1 = k.findKids(candies1, 1);
        k.display(ans1);
        
        int[] candies2 = {12,1,12};
        List<Boolean> ans2 = k.findKids(candies2, 10);
        k.display(ans2);
    }
}
