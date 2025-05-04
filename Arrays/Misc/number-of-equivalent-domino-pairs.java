//Problem: https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/




//Brute Force: Using HashMap solution
import java.util.*;
import java.io.*;

class EquivalentDominoes {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count=0;
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<dominoes.length; i++) {
            int val1 = Math.min(dominoes[i][0], dominoes[i][1]);
            int val2 = Math.max(dominoes[i][1], dominoes[i][0]);
            String pair = val1 + "," + val2;
            if(mp.containsKey(pair)) {
                count+=mp.get(pair);
                mp.put(pair, mp.get(pair) + 1);
            } else {
                mp.put(pair, 1);
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        EquivalentDominoes pairs = new EquivalentDominoes();
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(pairs.numEquivDominoPairs(dominoes));
        
        int[][] dominoes1 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(pairs.numEquivDominoPairs(dominoes1));
    }
}





//Optimal solution
import java.util.*;
import java.io.*;

class EquivalentDominoes {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count=0;
        int[] pairs = new int[100];
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<dominoes.length; i++) {
            int val1 = Math.min(dominoes[i][0], dominoes[i][1]);
            int val2 = Math.max(dominoes[i][1], dominoes[i][0]);
            int key = val1 * 10 + val2;
            count+=pairs[key];
            pairs[key]++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        EquivalentDominoes pairs = new EquivalentDominoes();
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(pairs.numEquivDominoPairs(dominoes));
        
        int[][] dominoes1 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(pairs.numEquivDominoPairs(dominoes1));
    }
}