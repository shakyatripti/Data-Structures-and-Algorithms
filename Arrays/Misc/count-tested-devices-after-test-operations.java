//Problem: https://leetcode.com/problems/count-tested-devices-after-test-operations/description/





import java.io.*;
import java.util.*;

class TestOperations {
    public int count(int[] batteryPercentages) {
        int devices = 0, n = batteryPercentages.length;
        for(int i=0; i<n; i++) {
            if(batteryPercentages[i]!=0) {
                devices++;
                for(int j=i+1; j<n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j]-1);
                }
            }
        }
        return devices;
    }
}

class Main {
    public static void main(String[] args) {
        TestOperations device = new TestOperations();
        int[] batteryPercentages = {1,1,2,1,3};
        System.out.println(device.count(batteryPercentages));
        
        int[] batteryPercentages1 = {0,1,2};
        System.out.println(device.count(batteryPercentages1));
    }
}