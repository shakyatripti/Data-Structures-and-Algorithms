//Problem: https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/





import java.io.*;
import java.util.*;

class LosersOrWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> win = new ArrayList<Integer>();
        List<Integer> oneLost = new ArrayList<Integer>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            mp.put(loser, mp.getOrDefault(loser, 0) + 1);
            mp.put(winner, mp.getOrDefault(winner, 0) + 0);
        }

        for(Map.Entry<Integer, Integer> it: mp.entrySet()) {
            int val = it.getValue();
            if(val==0) {
                win.add(it.getKey());
            } else if(val==1) {
                oneLost.add(it.getKey());
            }
        }
        Collections.sort(win);
        Collections.sort(oneLost);
        ans.add(win);
        ans.add(oneLost);
        return ans;
    }
    
    public void display(List<List<Integer>> ans) {
        for(int i=0; i<2; i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LosersOrWinners players = new LosersOrWinners();
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> ans = players.findWinners(matches);
        players.display(ans);
        
        int[][] matches1 = {{2,3},{1,3},{5,4},{6,4}};
        List<List<Integer>> ans1 = players.findWinners(matches1);
        players.display(ans1);
    }
}