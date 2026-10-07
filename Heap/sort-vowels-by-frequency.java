//Problem: https://leetcode.com/problems/sort-vowels-by-frequency/description/






import java.io.*;
import java.util.*;


class SortVowels {
    public String sortByFrequency(String s) {
        String ans = "";
        int[] freq = new int[26];
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for(int i=0; i<s.length(); i++) {
            int val = s.charAt(i) - 'a';
            freq[val]++;
            if(index[val]==-1) {
                index[val] = i;
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)-> {
            if(freq[a-'a']==freq[b-'a']) {
                return Integer.compare(index[a-'a'], index[b-'a']);
            } else {
                return Integer.compare(freq[b-'a'], freq[a-'a']);
            }
        });

        for(char ch: s.toCharArray()) {
            if(ch=='a' || ch=='e' || ch=='o' || ch=='u' || ch=='i') {
                pq.add(ch);
            }
        }

        for(char ch: s.toCharArray()) {
            if(ch=='a' || ch=='e' || ch=='o' || ch=='u' || ch=='i') {
                ans+=pq.poll();
            } else {
                ans+=ch;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SortVowels str = new SortVowels();
        System.out.println(str.sortByFrequency("leetcode"));
        System.out.println(str.sortByFrequency("aeiaaioooa"));
        System.out.println(str.sortByFrequency("baeiou"));
        System.out.println(str.sortByFrequency("pymmijoozi"));
    } 
}