//Problem: https://leetcode.com/problems/implement-router/description/



import java.io.*;
import java.util.*;

class Router {
    HashMap<Integer, List<Integer>> mp = new HashMap<>();//Contains all packets
    HashMap<Integer, Integer> mpp = new HashMap<>();// contains destinations that are removed
    Queue<List<Integer>> q = new LinkedList<>();
    Set<String> duplicates = new HashSet<>();
    int maxSize = 0;
    public Router(int memoryLimit) {
        Queue<List<Integer>> q = new LinkedList<>();
        maxSize = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String str = source + ":" + destination + ":" + timestamp;
        if(duplicates.contains(str)) {
            return false;
        }
        if(q.size() >= maxSize) {
            List<Integer> packet = q.poll();
            String str2 = packet.get(0) + ":" + packet.get(1) + ":" + packet.get(2);
            duplicates.remove(str2);
            mpp.put(packet.get(1), mpp.getOrDefault(packet.get(1), 0) + 1);
            
        }
        q.add(new ArrayList<>(Arrays.asList(source, destination, timestamp)));
        duplicates.add(str);
        mp.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(q.isEmpty()) {
            return new int[]{};
        }
        List<Integer> packet = q.poll();
        int[] fwd = new int[3];
        fwd[0] = packet.get(0);
        fwd[1] = packet.get(1);
        fwd[2] = packet.get(2);
        String str = packet.get(0) + ":" + packet.get(1) + ":" + packet.get(2);
        duplicates.remove(str);
        mpp.put(packet.get(1), mpp.getOrDefault(packet.get(1), 0) + 1);
        return fwd;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!mp.containsKey(destination)) {
            return 0;
        }
        List<Integer> packets = mp.get(destination);
        int totalRemoved = mpp.getOrDefault(destination, 0);
        int lower = lowerBound(packets, startTime, totalRemoved);
        int upper = upperBound(packets, endTime, totalRemoved);
        return upper - lower;
    }
    
    public int lowerBound(List<Integer> packets, int target, int start) {
        int l=start, r=packets.size();
        while(l<r) {
            int mid = l + (r-l)/2;
            if(packets.get(mid) < target) {
                l = mid  + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    public int upperBound(List<Integer> packets, int target, int start) {
        int l=start, r=packets.size();
        while(l<r) {
            int mid = l + (r-l)/2;
            if(packets.get(mid) <= target) {
                l = mid  + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

class Main {
    public static void main(String[] args) {
        Router router = new Router(2);
        System.out.println(router.addPacket(3,1,3));
        System.out.println(router.addPacket(1,2,3));
        System.out.println(router.addPacket(4,5,3));
        System.out.println(router.getCount(1,2,3));
        
        Router router1 = new Router(3);
        System.out.println(router1.addPacket(1,4,90));
        System.out.println(router1.addPacket(2,5,90));
        System.out.println(router1.addPacket(1,4,90));
        System.out.println(router1.addPacket(3,5,95));
        System.out.println(router1.addPacket(4,5,105));
        int[] fwd = router1.forwardPacket();
        for(int i: fwd) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.println(router1.addPacket(5,2,110));
        System.out.println(router1.getCount(5,100,110));
    }
}