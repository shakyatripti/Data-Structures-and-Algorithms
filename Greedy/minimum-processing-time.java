//Problem: https://leetcode.com/problems/minimum-processing-time/description/




import java.io.*;
import java.util.*;

class ProcessingTime {
    public int minTime(List<Integer> processorTime, List<Integer> tasks) {
        int ans = 0, k=processorTime.size()-1;
        Collections.sort(tasks);
        Collections.sort(processorTime);
        for(int i=0; i<tasks.size(); i+=4) {
            for(int j=i; j<i+4; j++) {
                int val = tasks.get(j) + processorTime.get(k);
                ans=Math.max(val, ans);
            }
            k--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ProcessingTime arr = new ProcessingTime();
        List<Integer> processorTime = new ArrayList(Arrays.asList(8,10));
        List<Integer> tasks = new ArrayList(Arrays.asList(2,2,3,1,8,7,4,5));
        System.out.println(arr.minTime(processorTime, tasks));
        
        List<Integer> processorTime1 = new ArrayList(Arrays.asList(10,20));
        List<Integer> tasks1 = new ArrayList(Arrays.asList(2,3,1,2,5,8,4,3));
        System.out.println(arr.minTime(processorTime1, tasks1));
    }
}