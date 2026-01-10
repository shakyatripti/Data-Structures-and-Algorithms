//Problem: https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/




import java.io.*;
import java.util.*;


class WordsFormedByLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> mp1 = new HashMap<>();
        int maxVal = 0;
        for(int i=0; i<letters.length; i++) {
            mp.put(letters[i], mp.getOrDefault(letters[i], 0) + 1);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        findSubsets(ans, res, 0, words);
        for(int i=0; i<ans.size(); i++) {
            mp1 = new HashMap<>(mp);
            int total = 0;
            for(int j=0; j<ans.get(i).size(); j++) {
                String w = ans.get(i).get(j);
                if(canFormWords(w, mp1)) {
                    total+=calcScore(w, score);
                }
            }
            maxVal = Math.max(maxVal, total);
        }
        return maxVal;
    }

    public void findSubsets(ArrayList<ArrayList<String>> ans, ArrayList<String> res, int i, String[] words) {
        if(i==words.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(words[i]);
        findSubsets(ans, res, i+1, words);
        res.remove(res.size()-1);
        findSubsets(ans, res, i+1, words);
    }

    public int calcScore(String word, int[] score) {
        int ans = 0;
        for(char ch: word.toCharArray()) {
            ans+=score[ch-'a'];
        }
        return ans;
    }

    public boolean canFormWords(String word, HashMap<Character, Integer> mp) {
        for(char ch: word.toCharArray()) {
            if(!mp.containsKey(ch)) {
                return false;
            }
            mp.put(ch, mp.get(ch)-1);
            if(mp.get(ch)==0) {
                mp.remove(ch);
            }
        }
        return true;
    } 
}

class Main {
    public static void main(String[] args) {
        WordsFormedByLetters str = new WordsFormedByLetters();
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(str.maxScoreWords(words, letters, score));
        
        String[] words1 = {"xxxz","ax","bx","cx"};
        char[] letters1 = {'z','a','b','c','x','x','x'};
        int[] score1 = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        System.out.println(str.maxScoreWords(words1, letters1, score1));
        
        
        String[] words2 = {"leetcode"};
        char[] letters2 = {'l','e','t','c','o','d'};
        int[] score2 = {0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        System.out.println(str.maxScoreWords(words2, letters2, score2));
    }
}