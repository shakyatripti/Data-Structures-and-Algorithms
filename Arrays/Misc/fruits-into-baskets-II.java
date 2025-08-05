//Problem: https://leetcode.com/problems/fruits-into-baskets-ii/description/




import java.io.*;
import java.util.*;

class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int leftOvers = 0;
        for(int i=0; i<fruits.length; i++) {
            boolean unplaced = true;
            for(int j=0; j<baskets.length; j++) {
                if(fruits[i] <= baskets[j]) {
                    baskets[j] = -1;
                    unplaced = false;
                    break;
                }
            }
            if(unplaced) {
                leftOvers++;
            }
        }
        return leftOvers;
    }
}


class Main {
    public static void main(String[] args) {
        FruitsIntoBasketsII baskets = new FruitsIntoBasketsII();
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};
        System.out.println(baskets.numOfUnplacedFruits(fruits, baskets));
        
        int[] fruits1 = {3,6,1};
        int[] baskets1 = {6,4,7};
        System.out.println(baskets.numOfUnplacedFruits(fruits1, baskets1));
    }
}