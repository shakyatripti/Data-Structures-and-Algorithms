
//Problem: https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/description/




import java.io.*;
import java.util.*;

class BusyStudent {
    public int count(int[] startTime, int[] endTime, int queryTime) {
        int students = 0;
        for(int i=0; i<startTime.length; i++) {
            if(queryTime>=startTime[i] && queryTime<=endTime[i]) {
                students++;
            }
        }
        return students;
    }
}

class Main {
    public static void main(String[] args) {
        BusyStudent st = new BusyStudent();
        int[] startTime = {1,2,3};
        int[] endTime = {3,2,7};
        System.out.println(st.count(startTime, endTime, 4));
        
        int[] startTime1 = {4};
        int[] endTime1 = {4};
        System.out.println(st.count(startTime1, endTime1, 4));
    }
}
