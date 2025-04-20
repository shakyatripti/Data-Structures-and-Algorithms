//Problem: https://leetcode.com/problems/rabbits-in-forest/description/



import java.io.*;
import java.util.*;

class RabbitsInForest {
    public int numRabbits(int[] answers) {
        int totalRabbits = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<answers.length; i++) {
            mp.put(answers[i], mp.getOrDefault(answers[i], 0) + 1);
        }
        for(Map.Entry entry: mp.entrySet()) {
            int groupSize = (int) entry.getKey() + 1;
            int count = (int) entry.getValue();
            int groups = (int) Math.ceil((double) count/groupSize);
            totalRabbits+=groups * groupSize;
        }
        return totalRabbits;
    }
}

class Main {
    public static void main(String[] args) {
        RabbitsInForest rabbits = new RabbitsInForest();
        int[] answers = {1,1,2};
        System.out.println(rabbits.numRabbits(answers));
        
        int[] answers2 = {10,10,10};
        System.out.println(rabbits.numRabbits(answers2));
    }
}