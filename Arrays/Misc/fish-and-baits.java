/*Problem: (Asked in Visa coding test) Imagine that you are going fishing at the local pond. The size of the bait must be strictly 
    smaller than the size of the fish for it to catch. Once the fish is caught, it is removed from the pond and cannot be caught again. 
    However, each bait can be used to 3 times before depletion. 
    Given two arrays of fish and baits, where fish[i] corresponds to the size of the ith fish in the pond and baits[j] corresponds to the size 
    of the jth bait, your task is to return the maximum number of fish you can catch from the pond with the given baits.    
*/


import java.io.*;
import java.util.*;

class FishBaits {
    public int caughtFishes(int[] fish, int[] baits) {
        int caught=0, k=0, maxBaits=3, n=baits.length;
        Arrays.sort(fish);
        Arrays.sort(baits);
        for(int i=0; i<fish.length; i++) {
            if(maxBaits==0) {
                maxBaits=3;
                k++;
            }
            if(k < n && fish[i] > baits[k]) {
                maxBaits--;
                caught++;
            }
        }
        return caught;
    }
}

class Main {
    public static void main(String[] args) {
        FishBaits pond = new FishBaits();
        int[] fish = {1,2,3};
        int[] baits = {1};
        System.out.println(pond.caughtFishes(fish, baits));
        
        int[] fish1 = {2,2,3,4};
        int[] baits1 = {1,1};
        System.out.println(pond.caughtFishes(fish1, baits1));
        
        int[] fish2 = {4,2,1,5,11,6};
        int[] baits2 = {2};
        System.out.println(pond.caughtFishes(fish2, baits2));
    }
}