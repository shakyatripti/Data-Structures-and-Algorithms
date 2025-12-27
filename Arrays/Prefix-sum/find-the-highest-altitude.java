//Problem: https://leetcode.com/problems/find-the-highest-altitude/description/





import java.io.*;
import java.util.*;

class HighestAltitude {
    public int findLargest(int[] gain) {
        int sum = 0, ans = 0;
        for(int i=0; i<gain.length; i++) {
            sum+=gain[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        HighestAltitude peak = new HighestAltitude();
        int[] gain = {-5,1,5,0,-7};
        System.out.println(peak.findLargest(gain));
        
        int[] gain1 = {-4,-3,-2,-1,4,3,2};
        System.out.println(peak.findLargest(gain1));
    }
}