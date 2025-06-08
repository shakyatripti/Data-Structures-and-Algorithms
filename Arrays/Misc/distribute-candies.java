//Problem: https://leetcode.com/problems/distribute-candies/description/



import java.io.*;
import java.util.*;

class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candies = new HashSet<>();
        int n=candyType.length, m=n/2;
        for(int i=0; i<n; i++) {
           if(!candies.contains(candyType[i])) {
              candies.add(candyType[i]);
           }
        }
        return m > candies.size() ? candies.size() : m;
    }
}

class Main {
    public static void main(String[] args) {
        DistributeCandies candies = new DistributeCandies();
        int[] candyType = {1,1,2,2,3,3};
        System.out.println(candies.distributeCandies(candyType));
        
        int[] candyType1 = {6,6,6,6};
        System.out.println(candies.distributeCandies(candyType1));
        
        int[] candyType2 = {1,1,2,3};
        System.out.println(candies.distributeCandies(candyType2));
    }
}