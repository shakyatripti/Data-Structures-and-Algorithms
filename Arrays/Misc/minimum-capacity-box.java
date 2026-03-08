//Problem: https://leetcode.com/problems/minimum-capacity-box/description/




import java.io.*;
import java.util.*;

class CapacityBox {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minCapacity = Integer.MAX_VALUE, index = Integer.MAX_VALUE; 
        for(int i=0; i<capacity.length; i++) {
            if(capacity[i] >= itemSize && minCapacity > capacity[i]) {
                minCapacity = capacity[i];
                index = i;
            }
        }
        return index==Integer.MAX_VALUE ? -1 : index;
    }
}

class Main {
    public static void main(String[] args) {
        CapacityBox box = new CapacityBox();
        int[] capacity = {1,5,3,7};
        System.out.println(box.minimumIndex(capacity, 3));
        
        int[] capacity1 = {3,5,4,3};
        System.out.println(box.minimumIndex(capacity1, 2));
        
        int[] capacity2 = {4};
        System.out.println(box.minimumIndex(capacity2, 5));
    }
}