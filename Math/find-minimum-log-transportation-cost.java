//Problem: https://leetcode.com/problems/find-minimum-log-transportation-cost/description/




import java.io.*;
import java.util.*;

class LogTransportation {
    public long minCuttingCost(int n, int m, int k) {
        long cost = 0;
        if(n > k) {
            long r = n % k;
            if(r==0) {
                long div = n - k;
                cost+=div * div;
            } else {
                cost+= r * (n - r);
            }
        }
        if(m > k) {
            long r = m % k;
            if(r==0) {
                long div = (m-k);
                cost+=div * div;
            } else {
                cost+=r * (m - r);
            }
        }
        return cost;
    }
}

class Main {
    public static void main(String[] args) {
        LogTransportation trucks = new LogTransportation();
        System.out.println(trucks.minCuttingCost(6,5,5));
        System.out.println(trucks.minCuttingCost(4,4,6));
        System.out.println(trucks.minCuttingCost(9,5,5));
        System.out.println(trucks.minCuttingCost(1,4,2));
        System.out.println(trucks.minCuttingCost(1,6,3));
        System.out.println(trucks.minCuttingCost(49898,109372,62703));
    }
}