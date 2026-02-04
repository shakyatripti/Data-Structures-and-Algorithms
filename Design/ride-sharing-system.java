//Problem: https://leetcode.com/problems/design-ride-sharing-system/description/





import java.io.*;
import java.util.*;

class RideSharingSystem {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public RideSharingSystem() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void addRider(int riderId) {
        q1.add(riderId);
    }
    
    public void addDriver(int driverId) {
        q2.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        int[] ans = {-1, -1};
        if(!q1.isEmpty() && !q2.isEmpty()) {
            ans[0] = q2.poll();
            ans[1] = q1.poll();
        }
        return ans;
    }
    
    public void cancelRider(int riderId) {
        if(q1.contains(riderId)) {
            q1.remove(riderId);
        }
    }
}


class Main {
    public static void main(String[] args) {
        RideSharingSystem ride = new RideSharingSystem();
        ride.addRider(3);
        ride.addDriver(2);
        ride.addRider(1);
        int[] ans = ride.matchDriverWithRider();
        System.out.println(ans[0] + " " + ans[1]);
        ride.addDriver(5);
        ride.cancelRider(3);
        int[] ans1 = ride.matchDriverWithRider();
        System.out.println(ans1[0] + " " + ans1[1]);
        int[] ans2 = ride.matchDriverWithRider();
        System.out.println(ans2[0] + " " + ans2[1]);
        
        
        RideSharingSystem ride1 = new RideSharingSystem();
        ride1.addRider(8);
        ride1.addDriver(8);
        ride1.addDriver(6);
        int[] ans3 = ride1.matchDriverWithRider();
        System.out.println(ans3[0] + " " + ans3[1]);
        ride1.addRider(2);
        ride1.cancelRider(2);
        int[] ans4 = ride1.matchDriverWithRider();
        System.out.println(ans4[0] + " " + ans4[1]);
    }
}