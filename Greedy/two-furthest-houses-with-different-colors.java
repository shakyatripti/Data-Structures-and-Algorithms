//Problem: https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/



import java.io.*;
import java.util.*;

class TwoFurthestHouses {
    public int maxDistance(int[] colors) {
        int dist = 0;
        for(int i=0; i<colors.length; i++) {
            for(int j=colors.length-1; j>=i; j--) {
                if(colors[i]!=colors[j]) {
                    int distance = Math.abs(i-j);
                    dist = Math.max(dist, distance);
                }
            }
        }
        return dist;
    }
}

class Main {
    public static void main(String[] args) {
        TwoFurthestHouses houses = new TwoFurthestHouses();
        int[] colors = {1,2,1,6,1,1,1};
        System.out.println(houses.maxDistance(colors));
        
        int[] colors1 = {1,8,3,8,3};
        System.out.println(houses.maxDistance(colors1));
        
        int[] colors2 = {0,1};
        System.out.println(houses.maxDistance(colors2));
    }
}