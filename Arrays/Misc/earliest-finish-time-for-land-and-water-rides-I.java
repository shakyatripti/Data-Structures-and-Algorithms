//Problem: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/




import java.io.*;
import java.util.*;

class LandWaterRidesI {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int finishTime = Integer.MAX_VALUE;
        for(int i=0; i<landStartTime.length; i++) {
            for(int j=0; j<waterStartTime.length; j++) {
                int startLand = landStartTime[i];
                int endLand = landStartTime[i] + landDuration[i];
                int startWater = Math.max(endLand, waterStartTime[j]);
                int endWater = startWater + waterDuration[j];
                finishTime = Math.min(finishTime, endWater);

                startWater = waterStartTime[j];
                endWater = startWater + waterDuration[j];
                startLand = Math.max(endWater, landStartTime[i]);
                endLand = startLand + landDuration[i];
                finishTime = Math.min(finishTime, endLand);
            }
        }
        return finishTime;
    }
}


class Main {
    public static void main(String[] args) {
        LandWaterRidesI rides = new LandWaterRidesI();
        int[] landStartTime = {2,8};
        int[] landDuration = {4,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        System.out.println(rides.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
        
        int[] landStartTime1 = {5};
        int[] landDuration1 = {3};
        int[] waterStartTime1 = {1};
        int[] waterDuration1 = {10};
        System.out.println(rides.earliestFinishTime(landStartTime1, landDuration1, waterStartTime1, waterDuration1));
    }
    
}