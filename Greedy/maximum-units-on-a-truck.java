//Problem: https://leetcode.com/problems/maximum-units-on-a-truck/description/



import java.io.*;
import java.util.*;

class MaxUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x,y)->Integer.compare(y[1], x[1]));
        int maxUnits=0, i=0;
        while(i < boxTypes.length && truckSize > 0) {
            int boxes = Math.min(boxTypes[i][0], truckSize);
            maxUnits+=boxes*boxTypes[i][1];
            truckSize-=boxes;
            i++;
        }
        return maxUnits;
    }
}

class Main {
    public static void main(String[] args) {
        MaxUnitsOnTruck truck = new MaxUnitsOnTruck();
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        System.out.println(truck.maximumUnits(boxTypes, 4));
        
        int[][] boxTypes1 = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(truck.maximumUnits(boxTypes1, 10));
    }
}