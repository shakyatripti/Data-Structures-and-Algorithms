//Problem: https://leetcode.com/problems/rearrange-words-in-a-sentence/description/





//Brute force solution
import java.io.*;
import java.util.*;

class FormSentence {
    public String arrangeWords(String text) {
        String ans = "";
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> {
            if(x[0]!=y[0]) {
                return Integer.compare(x[0], y[0]);
            } else {
                return Integer.compare(x[1], y[1]);
            }
        });

        String[] words = text.split("\\ ");
        for(int i=0; i<words.length; i++) {
            int[] pair = {words[i].length(), i};
            pq.add(pair);
        }

        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            int index = pair[1];
            String w = words[index].toLowerCase();
            if(ans=="") {
                ans+=w.substring(0,1).toUpperCase() + w.substring(1);
            } else {
                ans+=" ";
                ans+=w;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        FormSentence sentence = new FormSentence();
        System.out.println(sentence.arrangeWords("Leetcode is cool"));
        System.out.println(sentence.arrangeWords("Keep calm and code on"));
        System.out.println(sentence.arrangeWords("To be or not to be"));
    }
}