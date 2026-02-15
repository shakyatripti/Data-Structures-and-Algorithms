//Problem: https://leetcode.com/problems/weighted-word-mapping/description/





import java.io.*;
import java.util.*;

class WeightedWords {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        for(int i=0; i<words.length; i++) {
            int sum = 0;
            for(char ch: words[i].toCharArray()) {
                sum+=weights[ch-'a'];
            }
            int val = 25 - sum % 26;
            char ch1 = (char) (val + 'a');
            ans+=ch1;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        WeightedWords str = new WeightedWords();
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(str.mapWordWeights(words, weights));
        
        String[] words1 = {"a","b","c"};
        int[] weights1 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(str.mapWordWeights(words1, weights1));
        
        String[] words2 = {"abcd"};
        int[] weights2 = {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        System.out.println(str.mapWordWeights(words2, weights2));
    }
}