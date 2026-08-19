//Problem: https://leetcode.com/problems/nearest-available-drone/description/





import java.io.*;
import java.util.*;


class AvailableDrones {
    public int nearestOne(int[][] drones, int[] target) {
        int index = Integer.MAX_VALUE, dist = Integer.MAX_VALUE, n = drones.length;
        for(int i=0; i<n; i++) {
            int diff = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            if(diff <= drones[i][2]) {
                if(dist==diff) {
                    index = Math.min(index, i);
                } 
                if(dist > diff) {
                    index = i;
                    dist = diff;
                }
            }
        }
        return index==Integer.MAX_VALUE ? -1 : index;
    }
}

class Main {
    public static void main(String[] args) {
        AvailableDrones arr = new AvailableDrones();
        int[][] drones = {{0,0,8},{2,2,9}};
        int[] target = {3,4};
        System.out.println(arr.nearestOne(drones, target));
        
        int[][] drones1 = {{2,1,5},{4,4,5},{6,6,8}};
        int[] target1 = {5,5};
        System.out.println(arr.nearestOne(drones1, target1));
        
        int[][] drones2 = {{4,4,5}};
        int[] target2 = {8,6};
        System.out.println(arr.nearestOne(drones2, target2));
        
        int[][] drones3 = {{2,9,3},{-25,0,15}};
        int[] target3 = {-25,-15};
        System.out.println(arr.nearestOne(drones3, target3));
        
        int[][] drones4 = {{-14,-13,65},{4,10,92}};
        int[] target4 = {-24,-23};
        System.out.println(arr.nearestOne(drones4, target4));
    }
}