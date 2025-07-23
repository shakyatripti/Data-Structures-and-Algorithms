//Problem: https://leetcode.com/problems/apple-redistribution-into-boxes/description/




import java.io.*;
import java.util.*;

class AppleRedistribution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples = 0, box=0, totalCapacity=0;
        for(int i=0; i<apple.length; i++) {
            totalApples+=apple[i];
        }
        for(int j=capacity.length-1; j>=0; j--) {
            totalCapacity+=capacity[j];
            if(totalCapacity < totalApples) {
                box++;
            } else {
                break;
            }
        }
        return box+1;
    }
}

class Main {
    public static void main(String[] args) {
        AppleRedistribution distribute = new AppleRedistribution();
        int[] apple = {1,3,2};
        int[] capacity = {4,3,1,5,2};
        System.out.println(distribute.minimumBoxes(apple, capacity));
        
        int[] apple1 = {5,5,5};
        int[] capacity1 = {2,4,2,7};
        System.out.println(distribute.minimumBoxes(apple1, capacity1));
        
        int[] apple2 = {9,8,8,2,3,1,6};
        int[] capacity2 = {10,1,4,10,8,5};
        System.out.println(distribute.minimumBoxes(apple2, capacity2));
    }
}