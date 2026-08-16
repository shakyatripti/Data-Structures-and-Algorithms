//Problem: https://leetcode.com/problems/elevator-requests-i/description/




import java.io.*;
import java.util.*;


class ElevatorRequests {
    public int totalTime(int n, int[] requests) {
        int sum = requests[0], m=requests.length;
        for(int i=1; i<m; i++) {
            sum+=Math.abs(requests[i] - requests[i-1]);
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        ElevatorRequests elevator = new ElevatorRequests();
        int[] requests = {2,1,4,3};
        System.out.println(elevator.totalTime(5, requests));
        
        int[] requests1 = {2,0,0};
        System.out.println(elevator.totalTime(3, requests1));
        
        int[] requests2 = {0,1};
        System.out.println(elevator.totalTime(2, requests2));
    }
}