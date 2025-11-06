//Problem: https://leetcode.com/problems/find-the-number-of-winning-players/




import java.io.*;
import java.util.*;

class WinningPlayers {
    public int countWinners(int n, int[][] pick) {
        int count = 0;
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<pick.length; i++) {
            if(mp.containsKey(pick[i][0])) {
               ArrayList<Integer> arr = mp.get(pick[i][0]);
               arr.add(pick[i][1]);
               mp.put(pick[i][0], arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(pick[i][1]);
                mp.put(pick[i][0], arr);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()) {
            int x = entry.getKey();
            ArrayList<Integer> arr = entry.getValue();
            int[] freq = new int[11];
            for(int i=0; i<arr.size(); i++) {
                freq[arr.get(i)]++;
                if(freq[arr.get(i)] > x) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
}

class Main {
    public static void main(String[] args) {
        WinningPlayers players = new WinningPlayers();
        int[][] pick = {{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}};
        System.out.println(players.countWinners(4, pick));
        
        int[][] pick1 = {{1,1},{1,2},{1,3},{1,4}};
        System.out.println(players.countWinners(5, pick1));
        
        int[][] pick2 = {{1,1},{2,4},{2,4},{2,4}};
        System.out.println(players.countWinners(5, pick2));
        
        int[][] pick3 = {{1,3},{2,10}};
        System.out.println(players.countWinners(3, pick3));
    }
}