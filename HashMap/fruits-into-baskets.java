//Problem: https://leetcode.com/problems/fruit-into-baskets/description/




import java.io.*;
import java.util.*;

class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        int l=0, r=0, ans=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(l < fruits.length && r < fruits.length) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);
            if(mp.size()>=3) {
                mp.put(fruits[l], mp.getOrDefault(fruits[l],0)-1);
                if(mp.get(fruits[l])<=0) {
                    mp.remove(fruits[l]);
                }
                l++;
            } 
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        FruitsIntoBaskets baskets = new FruitsIntoBaskets();
        int[] fruits = {1,2,1};
        System.out.println(baskets.totalFruit(fruits));
        
        int[] fruits1 = {0,1,2,2};
        System.out.println(baskets.totalFruit(fruits1));
        
        int[] fruits2 = {1,2,3,2,2};
        System.out.println(baskets.totalFruit(fruits2));
        
        int[] fruits3 = {4,7,7,0,8,3,8,2,5};
        System.out.println(baskets.totalFruit(fruits3));
        
        int[] fruits4 = {5,9,0,9,6,9,6,9,9,9};
        System.out.println(baskets.totalFruit(fruits4));
    }
}